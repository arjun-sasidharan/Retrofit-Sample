package com.example.retrofit_sample.api

import com.example.retrofit_sample.models.Post
import retrofit2.http.GET

interface BlogApi {

    @GET("posts")
    suspend fun getPost(): List<Post>
}