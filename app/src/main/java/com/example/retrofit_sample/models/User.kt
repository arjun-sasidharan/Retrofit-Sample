package com.example.retrofit_sample.models

data class User(
    val id: Int,
    val name: String,
    val username: String,
    val email: String,
    val company: Company,
    val website: String
) {
    data class Company(
        val name: String,
        val catchPhrase: String,
        val bs: String
    )
}
