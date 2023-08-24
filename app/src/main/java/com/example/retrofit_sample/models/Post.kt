package com.example.retrofit_sample.models

import java.io.Serializable

data class Post(
    val userId: Int,
    val id: Int,
    val title: String,
    val body: String
) : Serializable
// extending with serializable, so can be passed as intent extra