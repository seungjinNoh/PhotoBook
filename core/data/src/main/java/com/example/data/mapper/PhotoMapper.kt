package com.example.data.mapper

import com.example.data.PhotoInfo
import com.example.domain.entity.PhotoEntity

object PhotoMapper {
    fun toEntity(photoInfo: PhotoInfo): PhotoEntity {
        return PhotoEntity(
            id = photoInfo.id,
            path = photoInfo.path,
            title = photoInfo.title,
            w3w = photoInfo.w3w
        )
    }

}