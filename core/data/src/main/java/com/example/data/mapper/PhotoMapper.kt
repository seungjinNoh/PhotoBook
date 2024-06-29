package com.example.data.mapper

import com.example.data.PhotoEntity
import com.example.domain.model.Photo

object PhotoMapper {
    fun toEntity(photo: Photo): PhotoEntity {
        return PhotoEntity(
//            id = photo.id,
            path = photo.path,
            title = photo.title,
            w3w = photo.w3w
        )
    }

    fun toPhoto(photoEntity: PhotoEntity): Photo {
        return Photo(
//            id = photoEntity.id
            id = 1,
            path = photoEntity.path,
            title = photoEntity.title,
            w3w = photoEntity.w3w
        )
    }

}