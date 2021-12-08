package com.akshay.tmdbclient.presentation.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.akshay.tmdbclient.data.model.movie.Movie
import com.akshay.tmdbclient.domain.usecases.GetMoviesUsecase
import com.akshay.tmdbclient.domain.usecases.UpdateMoviesUseCase

class MovieViewModel(
    private val getMovieUseCase:GetMoviesUsecase,
    private val updateMoviesUseCase: UpdateMoviesUseCase
):ViewModel() {

    fun getMovies() = liveData<List<Movie>?> {
        val movieList = getMovieUseCase.execute()
        emit(movieList)
    }

    fun updateMovies() = liveData<List<Movie>?> {
        val movieList = updateMoviesUseCase.execute()
        emit(movieList)
    }
}