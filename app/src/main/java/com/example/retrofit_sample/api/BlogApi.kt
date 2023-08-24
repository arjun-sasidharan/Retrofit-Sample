package com.example.retrofit_sample.api

import com.example.retrofit_sample.models.Post
import com.example.retrofit_sample.models.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.PATCH
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

interface BlogApi {

    @GET("posts")
    suspend fun getPosts(
        @Query("_page") page: Int = 1, @Query("_limit") limit: Int = 10
    ): List<Post>

    // if want to add header for a single api only
    @Headers("Platform: Android")
    @GET("posts/{id}")
    suspend fun getPost(@Path("id") postId: Int): Post

    @GET("users/{id}")
    suspend fun getUser(@Path("id") userId: Int): User

    // request body contains the complete new post
    @PUT("posts/{id}")
    suspend fun updatePost(@Path("id") postId: Int, @Body post: Post): Post

    // request body only needs to contain the specific changes to the resource
    @PATCH("posts/{id}")
    suspend fun patchPost(@Path("id") postId: Int, @Body params: Map<String, String>): Post


    // passing header dynamicaly
    @DELETE("posts/{id}")
    suspend fun deletePost(@Header("Auth-Token") auth: String, @Path("id") postId: Int)

    @DELETE("posts/")
    suspend fun createPost(@Body post: Post): Post

    // For Callback style approach
    @GET("posts/{id}")
    fun getPostViaCallback(@Path("id") postId: Int): Call<Post>

    @GET("users/{id}")
    fun getUserViaCallback(@Path("id") userId: Int): Call<User>
}