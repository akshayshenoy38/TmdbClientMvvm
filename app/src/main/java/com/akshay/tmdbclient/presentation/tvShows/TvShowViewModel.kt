package com.akshay.tmdbclient.presentation.tvShows

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.akshay.tmdbclient.data.model.movie.Movie
import com.akshay.tmdbclient.data.model.tvshow.TvShow
import com.akshay.tmdbclient.domain.usecases.GetMoviesUsecase
import com.akshay.tmdbclient.domain.usecases.GetTvShowsUseCase
import com.akshay.tmdbclient.domain.usecases.UpdateMoviesUseCase
import com.akshay.tmdbclient.domain.usecases.UpdateTvShowsUseCase

class TvShowViewModel(
    private val getTvShowsUseCase: GetTvShowsUseCase,
    private val updateTvShowsUseCase: UpdateTvShowsUseCase
):ViewModel() {

    fun getTvShows() = liveData<List<TvShow>?> {
        val tvShowList = getTvShowsUseCase.execute()
        emit(tvShowList)
    }

    fun updateTvShows() = liveData<List<TvShow>?> {
        val tvShowList = updateTvShowsUseCase.execute()
        emit(tvShowList)
    }
}