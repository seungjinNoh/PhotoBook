package com.example.data.di

import android.content.Context
import androidx.room.Room
import com.example.data.database.PhotoDao
import com.example.data.database.PhotoDatabase
import com.example.data.repository.PhotoRepositoryImpl
import com.example.domain.repository.PhotoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providePhotoDatabase(@ApplicationContext context: Context): PhotoDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            PhotoDatabase::class.java,
            "photo_database"
        ).build()
    }

    @Provides
    fun providePhotoDao(database: PhotoDatabase): PhotoDao {
        return database.photoDao()
    }

    @Provides
    @Singleton
    fun provideRepository(photoDao: PhotoDao): PhotoRepository {
        return PhotoRepositoryImpl(photoDao)
    }
}