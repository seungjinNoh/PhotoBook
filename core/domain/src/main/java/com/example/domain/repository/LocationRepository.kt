package com.example.domain.repository

import com.what3words.javawrapper.response.Coordinates

interface LocationRepository {
    suspend fun getW3WWord(coordinates: Coordinates): String?
}