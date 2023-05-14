package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.databinding.ActivityAllDetailsBinding
import com.example.myapplication.databinding.DetailsRcLayoutBinding
import com.example.myapplication.databinding.ImageLayoutBinding

class DetailsAdapter (private val context : Context, private val list : ArrayList<Description>) : RecyclerView.Adapter<DetailsAdapter.ViewHolder>() {

    class ViewHolder(binding: DetailsRcLayoutBinding) : RecyclerView.ViewHolder(binding.root){
        val rlmain = binding.RLmain
        val title = binding.title
        val des = binding.des

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(DetailsRcLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text = list[position].getTitle()
        holder.des.text = list[position].getDes()
        if(position%2 == 0){
            holder.rlmain.setBackgroundColor(Color.parseColor("#EBEBEB"))
        }
        else{
            holder.rlmain.setBackgroundColor(Color.parseColor("#FFFFFF"))
        }
    }

}