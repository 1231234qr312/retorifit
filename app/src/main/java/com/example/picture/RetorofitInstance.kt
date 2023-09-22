package com.example.picture

import android.util.Log
import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetorofitInstance {
    val Tag="로그"
    private lateinit var retrofitclient: Retrofit

    val client=OkHttpClient.Builder()
    val loggingInterceptor=HttpLoggingInterceptor(object :HttpLoggingInterceptor.Logger{
        val loggingInterceptor=HttpLoggingInterceptor(object :HttpLoggingInterceptor.Logger{
            override fun log(message: String) {
                Log.d(Tag,"RetorofitInstance-log() called/message:$message")
            }
        })
    })



    fun getclient(baseUrl:String):Retrofit?{
        Log.d(Tag,"RetorofitInstact-getclient()called")

        if(retrofitclient==null){
            retrofitclient=Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return  retrofitclient
    }
}