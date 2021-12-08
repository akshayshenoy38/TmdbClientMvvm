package com.akshay.tmdbclient.data.repository.artist.datasource

import com.akshay.tmdbclient.data.model.artist.Artist
import com.akshay.tmdbclient.data.model.movie.Movie

interface ArtistLocalDataSource {

    suspend fun getArtistsFromDb():List<Artist>
    suspend fun saveArtistsToDb(artists:List<Artist>)
    suspend fun clearAll()
}