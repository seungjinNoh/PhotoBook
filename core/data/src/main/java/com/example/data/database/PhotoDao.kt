package com.example.data.database

import androidx.room.Dao
import com.example.domain.entity.PhotoEntity

@Dao
interface PhotoDao {
    fun addPhoto(photoEntity: PhotoEntity)
}