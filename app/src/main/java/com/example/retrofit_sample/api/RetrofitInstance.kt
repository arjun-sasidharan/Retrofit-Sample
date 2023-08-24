package com.example.retrofit_sample.api

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

private const val BASE_URL = "https://jsonplaceholder.typicode.com/"
object RetrofitInstance {

    private val moshi = Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }

    val api: BlogApi by lazy {
        retrofit.create(BlogApi::class.java)
    }

}