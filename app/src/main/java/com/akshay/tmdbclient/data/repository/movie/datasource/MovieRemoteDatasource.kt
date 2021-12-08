package com.akshay.tmdbclient.data.repository.movie.datasource

import com.akshay.tmdbclient.data.model.movie.MovieList
import retrofit2.Response

interface MovieRemoteDatasource {
    suspend fun getMovies() : Response<MovieList>
}