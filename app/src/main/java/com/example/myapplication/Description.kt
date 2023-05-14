package com.example.myapplication

data class Description(
    private var title : String,
    private var details : String
){
    fun getTitle() :String{
        return title
    }
    fun getDes() : String{
        return details
    }
}
