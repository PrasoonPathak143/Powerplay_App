package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.databinding.ImageLayoutBinding

class ImageAdapter(private val context : Context, private val imageList : ArrayList<Image>) : RecyclerView.Adapter<ImageAdapter.ViewHolder>() {

    class ViewHolder(binding: ImageLayoutBinding) : RecyclerView.ViewHolder(binding.root){
        val img = binding.image
        val text = binding.title
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ImageLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return imageList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(context).load(imageList[position].getImageUrl()).into(holder.img)
        holder.text.text = imageList[position].getImageName()
        holder.img.setOnClickListener {
            val intent = Intent(context, ImageOpen::class.java)
            intent.putExtra("imageName", imageList[position].getImageName())
            intent.putExtra("imageUrl", imageList[position].getImageUrl())
            context.startActivity(intent)
        }
    }

}
