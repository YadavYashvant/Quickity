package com.yashvant.org.apps.quickity.api_feature

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService{

    @GET("/hello")
    fun getHello(): Call<String>

    @GET("/todos")
    fun getUser(): Call<User>
}