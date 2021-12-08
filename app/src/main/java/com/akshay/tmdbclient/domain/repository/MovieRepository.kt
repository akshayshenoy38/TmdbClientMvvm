package com.akshay.tmdbclient.domain.repository

import com.akshay.tmdbclient.data.model.movie.Movie

interface MovieRepository {

    suspend fun getMovies():List<Movie>?
    suspend fun updateMovies():List<Movie>?
}