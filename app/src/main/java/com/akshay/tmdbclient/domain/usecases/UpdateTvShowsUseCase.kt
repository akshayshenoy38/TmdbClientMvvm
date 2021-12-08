package com.akshay.tmdbclient.domain.usecases

import com.akshay.tmdbclient.data.model.tvshow.TvShow
import com.akshay.tmdbclient.domain.repository.TvShowRepository

class UpdateTvShowsUseCase(private val tvShowRepository: TvShowRepository) {

    suspend fun execute():List<TvShow>? = tvShowRepository.updateTvShows()

}