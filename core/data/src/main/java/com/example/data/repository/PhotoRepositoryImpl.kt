package com.example.data.repository

import com.example.data.database.PhotoDao
import com.example.domain.entity.PhotoEntity
import com.example.domain.repository.PhotoRepository
import javax.inject.Inject

class PhotoRepositoryImpl @Inject constructor(
    private val photoDao: PhotoDao
) : PhotoRepository {

    override fun addPhoto(photoEntity: PhotoEntity) {
        photoDao.addPhoto(photoEntity)
    }

}