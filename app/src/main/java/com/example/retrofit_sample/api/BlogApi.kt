package com.example.retrofit_sample.api

import com.example.retrofit_sample.models.Post
import com.example.retrofit_sample.models.User
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface BlogApi {

    @GET("posts")
    suspend fun getPosts(
        @Query("_page") page: Int = 1, @Query("_limit") limit: Int = 10
    ): List<Post>

    @GET("posts/{id}")
    suspend fun getPost(@Path("id") postId: Int): Post

    @GET("users/{id}")
    suspend fun getUser(@Path("id") userId: Int): User
}