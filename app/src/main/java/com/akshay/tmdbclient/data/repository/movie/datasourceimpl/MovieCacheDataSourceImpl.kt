package com.akshay.tmdbclient.data.repository.movie.datasourceimpl

import com.akshay.tmdbclient.data.model.movie.Movie
import com.akshay.tmdbclient.data.repository.movie.datasource.MovieCacheDataSource

class MovieCacheDataSourceImpl: MovieCacheDataSource {
    private var moviesList = ArrayList<Movie>()
    override suspend fun getMoviesFromCache(): List<Movie> {
        return moviesList
    }

    override suspend fun saveMoviesToCache(movies: List<Movie>) {
        moviesList.clear()
        moviesList = ArrayList(movies)

    }
}