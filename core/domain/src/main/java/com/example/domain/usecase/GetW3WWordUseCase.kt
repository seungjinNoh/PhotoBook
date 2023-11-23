package com.example.domain.usecase

import com.example.domain.repository.LocationRepository
import com.what3words.javawrapper.response.Coordinates
import javax.inject.Inject

class GetW3WWordUseCase @Inject constructor(private val locationRepository: LocationRepository) {
    suspend fun execute(coordinates: Coordinates): String? = locationRepository.getW3WWord(coordinates)
}