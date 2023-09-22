package com.example.picture

import android.provider.SyncStateContract
import com.google.gson.JsonElement
import com.google.gson.annotations.SerializedName
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query
import retrofit2.Call

data class KakaoImage(
    @SerializedName("display_sitename")
    val name: String,
    val image: String,
    val collection: String // 받아오고 싶은 데이터값
)

data class MetaDate(
    @SerializedName("total_count") //@SerializedName를 이용해서 데이터와 매핑
    val totalCount:Int?,
    @SerializedName("is_end")
    val isEnd:Boolean? //null일수도있음
)

data class ImageResponse(
    @SerializedName("meta")
    val metaData: MetaDate?,
    @SerializedName("documents")
    var documents: MutableList<KakaoImage>?
)
enum class RESPONSE_STATE{
    OK,
    FAIL
}

interface Api {
    @GET("/v2/search/image")
    fun searchImage(
        @Header("Authorization") apiKey: String = constants.myApi,
        @Query("query") query: String,
        @Query("sort") sort: String,
        @Query("page") page: Int,
        @Query("size") size: Int,
    ): Call<JsonElement>
}





