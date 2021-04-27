package com.hemanth.halodoc.ui.web

import android.os.Bundle
import android.webkit.WebView
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.hemanth.halodoc.R
import com.hemanth.halodoc.util.Constants

class WebActivity : AppCompatActivity() {

    lateinit var webView: WebView

    val viewModel by lazy {
        ViewModelProvider(this).get(WebViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)
        init()
    }

    private fun init() {
        val url = intent.getStringExtra(Constants.INTENT_URL)
        webView = findViewById(R.id.webView)
        url?.let { webView.loadUrl(it) }

        findViewById<ImageView>(R.id.ivWebBack).setOnClickListener {
            onBackPressed()
        }
    }
}
