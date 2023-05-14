package com.example.myapplication

import android.graphics.Matrix
import android.graphics.RectF
import android.os.Bundle
import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent

import android.view.View
import android.widget.Button

import android.view.GestureDetector
import android.view.MotionEvent

import android.widget.ImageView

import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.GestureDetectorCompat
import com.bumptech.glide.Glide
import com.example.myapplication.databinding.ActivityImageOpenBinding
import com.github.chrisbanes.photoview.OnPhotoTapListener
import com.github.chrisbanes.photoview.PhotoView


class ImageOpen : AppCompatActivity() {
    private var binding : ActivityImageOpenBinding ?= null
    private var btn_des : Button ?= null
    private lateinit var gestureDetector : GestureDetectorCompat
    private lateinit var photoview : PhotoView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityImageOpenBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        btn_des = binding?.btnDetails
        photoview = binding?.photoView!!
        val intent = intent
        val imageUrl = intent.getStringExtra("imageUrl")
        val imageName = intent.getStringExtra("imageName")
        setSupportActionBar(binding?.toolbar)
        if(supportActionBar != null){
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            title = imageName
        }
        binding?.toolbar?.setNavigationOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
        btn_des?.setOnClickListener {
            val intent = Intent(this, AllDetails::class.java)
            startActivity(intent)
        }
        gestureDetector = GestureDetectorCompat(this, object : GestureDetector.SimpleOnGestureListener(){
            override fun onDoubleTap(e: MotionEvent): Boolean {
                e.let{
                    toggleMarkerVisibility(it.x,it.y)
                }
                return super.onDoubleTap(e)
            }

        })
        photoview?.setOnDoubleTapListener(object : GestureDetector.OnDoubleTapListener {
            override fun onSingleTapConfirmed(e: MotionEvent): Boolean {
                return false
            }

            override fun onDoubleTap(e: MotionEvent): Boolean {
                showDialog()
                return true // Disable zooming on double tap
            }

            override fun onDoubleTapEvent(e: MotionEvent): Boolean {
                return false
            }
        })


        Glide.with(this).load(imageUrl).into(photoview)

    }
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        gestureDetector.onTouchEvent(event!!)
        photoview.onTouchEvent(event)
        return super.onTouchEvent(event)
    }
    private fun toggleMarkerVisibility(x: Float, y: Float) {
        val imageMatrix: Matrix = photoview.imageMatrix
        val drawableRect = RectF(0f, 0f, photoview.drawable.intrinsicWidth.toFloat(), photoview.drawable.intrinsicHeight.toFloat())
        imageMatrix.mapRect(drawableRect)

        val touchX = (x - drawableRect.left) / drawableRect.width()
        val touchY = (y - drawableRect.top) / drawableRect.height()



    }
    private fun showDialog(){
        val builder = AlertDialog.Builder(this)
        builder.setView(R.layout.details_dialog).setTitle("Information").setPositiveButton("OK"){
                dialog, _ -> dialog.dismiss()
        }
            .setNegativeButton("Cancel"){
                dialog, _ -> dialog.dismiss()
            }
            .setCancelable(false)
        val alertDialog = builder.create()
        alertDialog.show()
    }
    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}