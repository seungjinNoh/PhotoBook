package com.example.photobook.viewmodel

import androidx.lifecycle.ViewModel
import com.example.data.PhotoInfo
import com.example.data.mapper.PhotoMapper
import com.example.domain.repository.PhotoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PhotoViewModel @Inject constructor(
    private val photoRepository: PhotoRepository
) : ViewModel() {

    fun addPhoto(photoInfo: PhotoInfo) {
        photoRepository.addPhoto(
            PhotoMapper.toEntity(photoInfo = photoInfo)
        )
    }
}