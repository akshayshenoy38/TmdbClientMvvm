package com.akshay.tmdbclient.data.repository.movie.datasource

import com.akshay.tmdbclient.data.model.movie.Movie

interface MovieLocalDataSource {

    suspend fun getMoviesFromDb():List<Movie>
    suspend fun saveMoviesToDb(movies:List<Movie>)
    suspend fun clearAll()
}