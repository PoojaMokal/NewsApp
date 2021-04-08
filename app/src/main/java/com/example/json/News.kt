package com.example.json

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

data class News(val totalResults:Int,val articles:List<Article>) {

}