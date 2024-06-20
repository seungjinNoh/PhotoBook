package com.example.domain.repository

import com.example.domain.model.Photo

interface PhotoRepository {
    fun addPhoto(photo: Photo)
}