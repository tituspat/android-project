package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageView
import android.widget.TextView

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val imageView: ImageView = findViewById(R.id.detail_image)
        val nameTextView: TextView = findViewById(R.id.detail_name)
        val countTextView: TextView = findViewById(R.id.detail_count)

        val imageResId = intent.getIntExtra("imageResId", 0)
        val itemName = intent.getStringExtra("itemName")
        val itemCount = intent.getIntExtra("itemCount", 0)

        imageView.setImageResource(imageResId)
        nameTextView.text = itemName
        countTextView.text = itemCount.toString()
    }
}