package com.akshay.tmdbclient.domain.usecases

import com.akshay.tmdbclient.data.model.artist.Artist
import com.akshay.tmdbclient.domain.repository.ArtistRepository

class UpdateArtistUseCase(private val artistRepository: ArtistRepository) {

    suspend fun execute():List<Artist>? = artistRepository.updateArtists()
}