package com.example.data.repository

import com.example.data.database.PhotoDao
import com.example.data.mapper.PhotoMapper
import com.example.domain.model.Photo
import com.example.domain.repository.PhotoRepository
import javax.inject.Inject

class PhotoRepositoryImpl @Inject constructor(
    private val photoDao: PhotoDao
) : PhotoRepository {

    override fun addPhoto(photo: Photo) {
        photoDao.addPhoto(PhotoMapper.toEntity(photo))
    }

}