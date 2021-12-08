package com.akshay.tmdbclient.data.repository.artist.datasource

import com.akshay.tmdbclient.data.model.artist.ArtistList
import com.akshay.tmdbclient.data.model.movie.MovieList
import retrofit2.Response

interface ArtistRemoteDatasource {
    suspend fun getArtists() : Response<ArtistList>
}