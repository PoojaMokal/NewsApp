package com.example.json

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.get
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class NewsAdapter(val context: Context,val articles: List<Article>):RecyclerView.Adapter<ArticleViewHolder>() {




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
        return ArticleViewHolder(v)
    }




    override fun getItemCount(): Int {
      return articles.size
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val article=articles[position]
        holder.newsTitle.text=article.title
        holder.newsDescription.text=article.descriptor
        Glide.with(context).load(article.urlToImage).into(holder.newsImage)
    }
}
class ArticleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    var newsImage = itemView.findViewById<ImageView>(R.id.newsImage)
    var newsTitle = itemView.findViewById<TextView>(R.id.newsTitle)
    var newsDescription = itemView.findViewById<TextView>(R.id.newsDescription)
}
