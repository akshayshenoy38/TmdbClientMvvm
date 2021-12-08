package com.akshay.tmdbclient.presentation.tvShows

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.akshay.tmdbclient.domain.usecases.GetMoviesUsecase
import com.akshay.tmdbclient.domain.usecases.GetTvShowsUseCase
import com.akshay.tmdbclient.domain.usecases.UpdateMoviesUseCase
import com.akshay.tmdbclient.domain.usecases.UpdateTvShowsUseCase

class TvShowViewModelFactory(
    private val getTvShowsUseCase: GetTvShowsUseCase,
    private val updateTvShowsUseCase: UpdateTvShowsUseCase
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TvShowViewModel(getTvShowsUseCase,updateTvShowsUseCase) as T
    }
}