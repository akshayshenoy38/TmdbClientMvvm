package com.akshay.tmdbclient.presentation.di.tvshow

import com.akshay.tmdbclient.domain.usecases.GetArtistsUseCase
import com.akshay.tmdbclient.domain.usecases.GetTvShowsUseCase
import com.akshay.tmdbclient.domain.usecases.UpdateArtistUseCase
import com.akshay.tmdbclient.domain.usecases.UpdateTvShowsUseCase
import com.akshay.tmdbclient.presentation.artist.ArtistViewModelFactory
import com.akshay.tmdbclient.presentation.tvShows.TvShowViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class TvShowModule {

    @TvShowScope
    @Provides
    fun providesTvShowViewModelFactory(
        getTvShowsUseCase: GetTvShowsUseCase,
        updateTvShowsUseCase: UpdateTvShowsUseCase
    ):TvShowViewModelFactory {

        return TvShowViewModelFactory(getTvShowsUseCase,updateTvShowsUseCase)

    }
}