package com.akshay.tmdbclient.domain.repository

import com.akshay.tmdbclient.data.model.artist.Artist
import com.akshay.tmdbclient.data.model.movie.Movie

interface ArtistRepository {

    suspend fun getArtists():List<Artist>?
    suspend fun updateArtists():List<Artist>?
}