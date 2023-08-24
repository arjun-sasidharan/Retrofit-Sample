package com.example.retrofit_sample.edit

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.retrofit_sample.models.Post

class EditViewModel : ViewModel() {
    private val _post: MutableLiveData<Post?> = MutableLiveData()
    val post: LiveData<Post?>
        get() = _post

    private val _currentStatus = MutableLiveData<ResultStatus>(ResultStatus.IDLE)
    val currentStatus: LiveData<ResultStatus>
        get() = _currentStatus

    fun updatePost(postId: Int, newPostData: Post) {
        // TODO: send PUT request
    }

    fun patchPost(postId: Int, title: String, body: String) {
        // TODO: send PATCH request
    }

    fun deletePost(postId: Int) {
        // TODO: send DELETE request
    }
}