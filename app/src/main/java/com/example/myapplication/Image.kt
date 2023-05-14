package com.example.myapplication

class Image(
    private var id : Int,
    private var imageName : String,
    private var imageUrl : String
){
    fun getImageUrl() : String{
        return imageUrl
    }
    fun getImageName() : String{
        return imageName
    }
    fun getId() : Int{
        return id
    }
}