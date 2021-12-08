package com.akshay.tmdbclient.data.repository.movie.datasourceimpl

import com.akshay.tmdbclient.data.api.TmdbService
import com.akshay.tmdbclient.data.model.movie.MovieList
import com.akshay.tmdbclient.data.repository.movie.datasource.MovieRemoteDatasource
import retrofit2.Response

class MovieRemoteDataSourceImpl(private val tmdbService: TmdbService,private val apiKey:String):
    MovieRemoteDatasource {
    override suspend fun getMovies(): Response<MovieList> {
        return tmdbService.getPopularMovies(apiKey)
    }

}