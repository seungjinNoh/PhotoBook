package com.example.photobook.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.Photo
import com.example.domain.repository.PhotoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
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
        viewModelScope.launch(Dispatchers.IO) {
            photoRepository.addPhoto(photo)
        }
    }

}