package com.example.retrofit_sample

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofit_sample.api.RetrofitInstance
import com.example.retrofit_sample.models.Post
import kotlinx.coroutines.launch

private const val TAG = "MainViewModel"

class MainViewModel : ViewModel() {
    private val _posts: MutableLiveData<List<Post>> = MutableLiveData()
    val posts: LiveData<List<Post>>
        get() = _posts

    private val _isLoading = MutableLiveData(false)
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    fun getPosts() {
        viewModelScope.launch {
            _isLoading.value = true
            val fetchedPost = RetrofitInstance.api.getPost()
            _posts.value = fetchedPost
            _isLoading.value = false
        }
    }
}