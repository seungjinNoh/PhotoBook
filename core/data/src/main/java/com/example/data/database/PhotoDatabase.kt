package com.example.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.data.PhotoEntity

@Database(entities = [PhotoEntity::class], version = 1, exportSchema = false)
abstract class PhotoDatabase : RoomDatabase() {
    abstract fun photoDao(): PhotoDao
}