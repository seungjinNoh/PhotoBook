package com.example.photobook.viewmodel

import androidx.lifecycle.ViewModel
import com.example.data.PhotoEntity
import com.example.data.mapper.PhotoMapper
import com.example.domain.model.Photo
import com.example.domain.repository.PhotoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class EditViewModel @Inject constructor(
    private val photoRepository: PhotoRepository
) : ViewModel() {


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

    fun savePhoto(photo: Photo) {
        //todo 저장 로직 작성
        photoRepository.addPhoto(
            photo = photo
        )
    }



}