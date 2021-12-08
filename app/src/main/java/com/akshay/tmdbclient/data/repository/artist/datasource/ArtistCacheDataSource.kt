package com.akshay.tmdbclient.data.repository.artist.datasource

import com.akshay.tmdbclient.data.model.artist.Artist
import com.akshay.tmdbclient.data.model.movie.Movie

interface ArtistCacheDataSource {

    suspend fun getArtistFromCache():List<Artist>

    suspend fun saveArtistsToCache(artists:List<Artist>)
}