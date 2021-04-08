package com.example.json

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var adapter: NewsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        gettNews()
    }

    private fun gettNews() {
        val news =NewService.newsInstance.getHeadLines("in",page = 1)
        news.enqueue(object : Callback<News>{
            override fun onFailure(call: Call<News>, t: Throwable) {
                Log.d("News Application","Something went wrong",t)
            }

            override fun onResponse(call: Call<News>, response: Response<News>) {
                val news =response.body()
                if(news!=null){
                    Log.d("News application",news.toString())
                    adapter = NewsAdapter(this@MainActivity,news.articles)
                    newsList.adapter=adapter
                   // newsList.layoutManager=LinearLayoutManager(this@MainActivity)

                    val linearLayoutManager:LinearLayoutManager = LinearLayoutManager(this@MainActivity)
                    linearLayoutManager.orientation = LinearLayoutManager. VERTICAL
                    newsList.layoutManager = linearLayoutManager
                }
            }

        })
    }
}