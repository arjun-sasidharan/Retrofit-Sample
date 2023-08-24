package com.example.retrofit_sample.edit

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofit_sample.api.RetrofitInstance
import com.example.retrofit_sample.models.Post
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.Dispatcher
import java.lang.Exception

class EditViewModel : ViewModel() {
    private val _post: MutableLiveData<Post?> = MutableLiveData()
    val post: LiveData<Post?>
        get() = _post

    private val _currentStatus = MutableLiveData<ResultStatus>(ResultStatus.IDLE)
    val currentStatus: LiveData<ResultStatus>
        get() = _currentStatus

    private val _wasDeletionSuccessful = MutableLiveData<Boolean>(false)
    val wasDeletionSuccessful: LiveData<Boolean>
        get() = _wasDeletionSuccessful


    fun updatePost(postId: Int, newPostData: Post) {
        viewModelScope.launch {
            try {
                _post.value = null
                _currentStatus.value = ResultStatus.WORKING
                val updatedPost = RetrofitInstance.api.updatePost(postId, newPostData)
                _post.value = updatedPost
                _currentStatus.value = ResultStatus.SUCCESS
            } catch (e: Exception) {
                _currentStatus.value = ResultStatus.ERROR
            }
        }
    }

    fun patchPost(postId: Int, title: String, body: String) {
        viewModelScope.launch {
            try {
                _currentStatus.value = ResultStatus.WORKING
                _post.value = null
                val patchedPost =
                    RetrofitInstance.api.patchPost(postId, mapOf("title" to title, "body" to body))
                _post.value = patchedPost
                _currentStatus.value = ResultStatus.SUCCESS
            } catch (e: Exception) {
                _currentStatus.value = ResultStatus.ERROR
            }

        }
    }

    fun deletePost(postId: Int) {
        viewModelScope.launch {
            try {
                _currentStatus.value = ResultStatus.WORKING
                RetrofitInstance.api.deletePost("1234AuthToken",postId)
                _post.value = null
                _wasDeletionSuccessful.value = true
                _currentStatus.value = ResultStatus.SUCCESS
            } catch (e: Exception) {
                _wasDeletionSuccessful.value = false
                _currentStatus.value = ResultStatus.ERROR
            }
        }
    }

    // Creating our own coroutine scope to make network request
    private fun createPost() {
        CoroutineScope(Dispatchers.IO).launch {
            val localNewPost = Post(2, 32, "My post title", "post id #32")
            val newPost = RetrofitInstance.api.createPost(localNewPost)
        }
    }

}