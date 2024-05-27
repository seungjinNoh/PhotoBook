package com.example.data.database

import androidx.room.Dao
import androidx.room.Insert
import com.example.domain.entity.PhotoEntity

@Dao
interface PhotoDao {

    @Insert
    fun addPhoto(photoEntity: PhotoEntity)
}