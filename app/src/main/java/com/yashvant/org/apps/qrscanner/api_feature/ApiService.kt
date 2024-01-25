package com.yashvant.org.apps.qrscanner.api_feature

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService{
    @GET("/posts/{id}")
    fun getPostsbyId(@Path("id") postId: Int): Call<Post>
}