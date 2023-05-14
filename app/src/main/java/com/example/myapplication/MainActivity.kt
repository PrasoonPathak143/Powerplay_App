package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var binding : ActivityMainBinding ?= null
    private var imageList : ArrayList<Image> ?= null
    private var imageAdapter : ImageAdapter ?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        setImage()
    }
    private fun setImage(){
        imageList = Constants.imageList()
        binding?.rcImage?.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        imageAdapter = ImageAdapter(this,imageList!!)
        binding?.rcImage?.adapter = imageAdapter
    }
    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}