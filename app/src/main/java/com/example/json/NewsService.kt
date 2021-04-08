package com.example.json

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

//https://newsapi.org/v2/top-headlines?country=in&apiKey=b4da4f42d6ff49da84d2b05ad9482c6e
//https://newsapi.org/v2/everything?q=tesla&from=2021-03-07&sortBy=publishedAt&apiKey=b4da4f42d6ff49da84d2b05ad9482c6e

const val BASE_URL = "https://newsapi.org/"
const val API_KEY = "b4da4f42d6ff49da84d2b05ad9482c6e"
interface NewsInterface {

    @GET("v2/top-headlines?apiKey=b4da4f42d6ff49da84d2b05ad9482c6e")
    fun getHeadLines(@Query("country") country:String,@Query("page") page:Int):Call<News>

}

object NewService{
    val newsInstance: NewsInterface
    init {
        val retrofit =Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        newsInstance = retrofit.create(NewsInterface::class.java)
    }
}