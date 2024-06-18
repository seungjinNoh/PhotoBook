package com.example.photobook.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class EditViewModel @Inject constructor() : ViewModel() {


    private val _title = MutableStateFlow("")
    val title: StateFlow<String> = _title

    private val _photoUri = MutableStateFlow<String?>(null)
    val photoUri: StateFlow<String?> = _photoUri

    fun updateTitle(title: String) {
        _title.value = title
    }

    fun updatePhoto(photoUri: String) {
        _photoUri.value = photoUri
    }

    fun savePhoto() {
        //todo 저장 로직 작성
    }



}