package com.example.retrofit_sample.models

import androidx.annotation.Keep
import com.squareup.moshi.Json
import java.io.Serializable

@Keep
data class Post(
    val userId: Int,
    val id: Int,
    val title: String,
    @Json(name = "body") val content: String
) : Serializable
// extending with serializable, so can be passed as intent extra