package com.hemanth.halodoc.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.hemanth.halodoc.R
import com.hemanth.halodoc.ui.home.adapter.HomeAdapter
import com.hemanth.halodoc.ui.web.WebActivity
import com.hemanth.halodoc.util.Constants

class HomeActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var parentLayout: ConstraintLayout
    private lateinit var searchView: SearchView
    private lateinit var progressBar: ProgressBar

    val adapter by lazy { HomeAdapter(viewModel.newsList) }

    val viewModel by lazy {
        ViewModelProvider(this).get(HomeViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        viewModel.fetchNews("sports")
        init()
        observeLiveData()
        adapterListener()
    }

    private fun adapterListener() {
        adapter.listener = { url ->
            launchWebView(url)
        }
    }

    private fun launchWebView(url: String) {
        val intent = Intent(this, WebActivity::class.java).apply {
            putExtra(Constants.INTENT_URL, url)
        }
        startActivity(intent)
    }

    private fun init() {
        recyclerView = findViewById(R.id.rvHome)
        parentLayout = findViewById(R.id.parentLayout)
        searchView = findViewById(R.id.svHome)
        progressBar = findViewById(R.id.progressBar)

        recyclerView.adapter = adapter

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let { viewModel.fetchNews(it) }
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })
    }

    private fun observeLiveData() {
        viewModel.event.observe(this, Observer {
            when (it.getContentIfNotPending()?.first) {
                Constants.LOADING -> showLoading(true)
                Constants.SUCCESS -> {
                    notifyAdapter()
                    showLoading(false)
                }
                Constants.ERROR -> {
                    showError(it.getContent().second.toString())
                    showLoading(false)
                }
            }
        })
    }

    private fun showLoading(isLoading: Boolean) {
        progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
    }

    private fun showError(error: String) {
        Snackbar.make(parentLayout, error, Snackbar.LENGTH_SHORT).show()
    }

    private fun notifyAdapter() {
        adapter.notifyDataSetChanged()
    }
}
