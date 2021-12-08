package com.akshay.tmdbclient.data.repository

import com.akshay.tmdbclient.data.model.movie.Movie
import com.akshay.tmdbclient.data.repository.movie.datasource.MovieRemoteDatasource
import com.akshay.tmdbclient.data.repository.movie.datasource.MovieCacheDataSource
import com.akshay.tmdbclient.data.repository.movie.datasource.MovieLocalDataSource
import com.akshay.tmdbclient.domain.repository.MovieRepository

class MovieRepositoryImpl(private val movieRemoteDatasource: MovieRemoteDatasource,
                          private val movieLocalDataSource: MovieLocalDataSource,
                          private val movieCacheDataSource: MovieCacheDataSource
):MovieRepository {
    override suspend fun getMovies(): List<Movie>? {
        return getMoviesFromCache()
    }

    override suspend fun updateMovies(): List<Movie>? {
        val newListOfMovies = getMoviesFromApis()
        movieLocalDataSource.clearAll()
        movieLocalDataSource.saveMoviesToDb(newListOfMovies)
        movieCacheDataSource.saveMoviesToCache(newListOfMovies)
        return newListOfMovies
    }

    suspend fun getMoviesFromApis() :List<Movie> {
        lateinit var moviesList:List<Movie>
        try {
            val response = movieRemoteDatasource.getMovies()
            val body = response.body()

            if (body != null) {
                moviesList = body.movies
            }
        } catch (e:Exception) {

        }
        return moviesList
    }


    suspend fun getMoviesFromDb()  :List<Movie>  {
        lateinit var moviesList:List<Movie>
        try {
            moviesList = movieLocalDataSource.getMoviesFromDb()


            if (moviesList.size>0) {
                return moviesList
            } else {
                moviesList = getMoviesFromApis()
                movieLocalDataSource.saveMoviesToDb(moviesList)
            }
        } catch (e:Exception) {

        }

        return moviesList

    }



    suspend fun getMoviesFromCache():List<Movie> {
        lateinit var moviesList:List<Movie>
        try {
            moviesList = movieCacheDataSource.getMoviesFromCache()


            if (moviesList.size>0) {
                return moviesList
            } else {
                moviesList = getMoviesFromApis()
                movieCacheDataSource.saveMoviesToCache(moviesList)
            }
        } catch (e:Exception) {

        }

        return moviesList
    }
}