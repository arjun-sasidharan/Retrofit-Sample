package com.example.retrofit_sample.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.retrofit_sample.models.Post
import com.example.retrofit_sample.models.User

class DetailViewModel: ViewModel() {
    private val _isLoading = MutableLiveData(false)
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    private val _post = MutableLiveData<Post>()
    val post: LiveData<Post>
        get() = _post

    private val _user = MutableLiveData<User>()
    val user: LiveData<User>
        get() = _user

    fun getPostDetails(postId: Int) {
        // TODO: fill this in
    }
}