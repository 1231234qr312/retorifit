package com.example.picture

import android.util.Log
import com.example.picture.RetorofitInstance.Tag
import com.google.gson.JsonElement
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.create

class RetrofitManager {
    companion object{
        val instance=RetrofitManager()

    }

    private val api:Api?=RetorofitInstance.getclient(constants.BASE_URL)?.create(Api::class.java)

    fun searchphotos(searchTerm: String?, completion: (RESPONSE_STATE,String) -> Unit) {
        val term = searchTerm ?: ""
        val page = 1 // 페이지 번호를 지정
        val sort = "accuracy" // 정렬 옵션을 지정 (원하는 값으로 수정)
        val size = 10 // 페이지 크기를 지정 (원하는 값으로 수정)

        val call = api?.searchImage(query = term, page = page, sort = sort, size = size)
        call?.enqueue(object : retrofit2.Callback<JsonElement> {
            override fun onResponse(call: Call<JsonElement>, response: Response<JsonElement>) {
                Log.d(Tag,"retorifitmanager - onresponseCalled")
                completion(RESPONSE_STATE.OK,response.raw().toString())
            }

            override fun onFailure(call: Call<JsonElement>, t: Throwable) {
                Log.d(Tag,"retorifitmanager - onFailure")
                completion(RESPONSE_STATE.FAIL,t.toString())

            }
        })
    }
}