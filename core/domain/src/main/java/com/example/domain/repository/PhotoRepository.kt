package com.example.domain.repository

import com.example.domain.entity.PhotoEntity

interface PhotoRepository {
    fun addPhoto(photoEntity: PhotoEntity)
}