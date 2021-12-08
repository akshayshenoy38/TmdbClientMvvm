package com.akshay.tmdbclient.presentation.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.akshay.tmdbclient.domain.usecases.GetMoviesUsecase
import com.akshay.tmdbclient.domain.usecases.UpdateMoviesUseCase

class MovieViewModelFactory(
    private val getMoviesUsecase: GetMoviesUsecase,
    private val updateMoviesUseCase: UpdateMoviesUseCase
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MovieViewModel(getMoviesUsecase,updateMoviesUseCase) as T
    }
}