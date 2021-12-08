package com.akshay.tmdbclient.domain.usecases

import com.akshay.tmdbclient.data.model.movie.Movie
import com.akshay.tmdbclient.domain.repository.MovieRepository

class GetMoviesUsecase(private val movieRepository: MovieRepository) {

    suspend fun execute():List<Movie>? = movieRepository.getMovies()
}