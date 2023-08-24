package com.example.retrofit_sample

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofit_sample.api.RetrofitInstance
import com.example.retrofit_sample.models.Post
import kotlinx.coroutines.launch
import java.lang.Exception

private const val TAG = "MainViewModel"

class MainViewModel : ViewModel() {
    private val _posts: MutableLiveData<List<Post>> = MutableLiveData()
    val posts: LiveData<List<Post>>
        get() = _posts

    private val _isLoading = MutableLiveData(false)
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    private val _errorMessage = MutableLiveData<String?>(null)
    val errorMessage: LiveData<String?>
        get() = _errorMessage

    fun getPosts() {
        viewModelScope.launch {
            _errorMessage.value = null
            _isLoading.value = true
            try {
                val fetchedPost = RetrofitInstance.api.getPosts()
                Log.i(TAG, "Got posts: $fetchedPost")
                _posts.value = fetchedPost
            } catch (e: Exception) {
                _errorMessage.value = e.message
                Log.e(TAG, "Exception $e")
            } finally {
                _isLoading.value = false
            }

            _isLoading.value = false
        }
    }
}