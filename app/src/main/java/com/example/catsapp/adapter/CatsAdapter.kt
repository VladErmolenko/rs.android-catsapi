package com.example.catsapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import com.example.catsapp.R
import com.example.catsapp.data.Cat

class CatsAdapter : RecyclerView.Adapter<CatsViewHolder>() {

    private val items = mutableListOf<Cat>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_item, null)
        return CatsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: CatsViewHolder, position: Int) {
        val fileName = items[position].id ?: ""
        val url = items[position].url ?: ""
        holder.bind(fileName, url)
    }

    fun addItems(newItems: List<Cat>) {
        items.addAll(newItems)
        notifyDataSetChanged()
    }
}

class CatsViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val textView = view.findViewById<TextView>(R.id.textView)
    private val imageView = view.findViewById<ImageView>(R.id.imageView)

    fun bind(filmName: String, url: String) {
        textView.text = url
        imageView.load(filmName)
    }
}