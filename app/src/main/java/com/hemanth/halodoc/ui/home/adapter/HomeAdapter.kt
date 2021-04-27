package com.hemanth.halodoc.ui.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hemanth.halodoc.R
import com.hemanth.halodoc.data.model.NewsPOJO

class HomeAdapter(private val arrayList: ArrayList<NewsPOJO.Hit>) :
    RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

    var listener: ((url: String) -> Unit)? = null

    class HomeViewHolder(view: View) : RecyclerView.ViewHolder(view.rootView) {
        val newTitle: TextView = view.findViewById(R.id.tvNewsTitle)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.home_item, parent, false);
        return HomeViewHolder(view)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.newTitle.text = arrayList.getOrNull(position)?.title
        holder.itemView.setOnClickListener {
            listener?.invoke(arrayList[position].url)
        }
    }

    override fun getItemCount(): Int = arrayList.size
}
