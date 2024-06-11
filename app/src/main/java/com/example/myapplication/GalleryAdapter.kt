package com.example.myapplication

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

import com.example.myapplication.model.GalleryItem


class GalleryAdapter(private val items: List<GalleryItem>) : RecyclerView.Adapter<GalleryAdapter.GalleryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GalleryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_gallery, parent, false)
        return GalleryViewHolder(view)
    }

    override fun onBindViewHolder(holder: GalleryViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    override fun getItemCount() = items.size

    class GalleryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageView: ImageView = itemView.findViewById(R.id.item_image)
        private val nameTextView: TextView = itemView.findViewById(R.id.item_name)
        private val countTextView: TextView = itemView.findViewById(R.id.item_count)

        fun bind(item: GalleryItem) {
            imageView.setImageResource(item.imageResId)
            nameTextView.text = item.itemName
            countTextView.text = item.itemCount.toString()

            itemView.setOnClickListener {
                val context = itemView.context
                val intent = Intent(context, DetailActivity::class.java).apply {
                    putExtra("imageResId", item.imageResId)
                    putExtra("itemName", item.itemName)
                    putExtra("itemCount", item.itemCount)
                }
                context.startActivity(intent)
            }
        }
    }
}