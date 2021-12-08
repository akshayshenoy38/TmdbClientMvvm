package com.akshay.tmdbclient.data.repository.movie.datasourceimpl

import com.akshay.tmdbclient.data.db.MovieDao
import com.akshay.tmdbclient.data.model.movie.Movie
import com.akshay.tmdbclient.data.repository.movie.datasource.MovieLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieLocalDataSourceImpl(private val movieDao: MovieDao): MovieLocalDataSource {
    override suspend fun getMoviesFromDb(): List<Movie> {
        return movieDao.getMovies()
    }

    override suspend fun saveMoviesToDb(movies: List<Movie>) {
        CoroutineScope(Dispatchers.IO).launch {
            movieDao.saveMovies(movies)
        }
    }

    override suspend fun clearAll() {
        movieDao.deleteAllMovies()
    }
}