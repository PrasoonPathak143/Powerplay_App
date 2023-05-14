package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.ActivityAllDetailsBinding

class AllDetails : AppCompatActivity() {
    private var binding : ActivityAllDetailsBinding ?= null
    private var list : ArrayList<Description> ?= null
    private var detailsAdapter : DetailsAdapter ?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAllDetailsBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        setSupportActionBar(binding?.toolbar)
        if(supportActionBar != null){
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }
        binding?.toolbar?.setNavigationOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
        setDetails()
    }
    private fun setDetails(){
        list = Constants.descriptionList()
        binding?.rcDescription?.layoutManager = LinearLayoutManager(this,
            LinearLayoutManager.VERTICAL,false)
        detailsAdapter = DetailsAdapter(this,list!!)
        binding?.rcDescription?.adapter = detailsAdapter
    }
}