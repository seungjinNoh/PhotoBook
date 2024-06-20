package com.example.data.database

import androidx.room.Dao
import androidx.room.Insert
import com.example.data.PhotoEntity
import com.example.domain.model.Photo

@Dao
interface PhotoDao {

    @Insert
    fun addPhoto(photoEntity: PhotoEntity)
}