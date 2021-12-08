package com.akshay.tmdbclient.presentation.di.movie

import com.akshay.tmdbclient.domain.usecases.GetArtistsUseCase
import com.akshay.tmdbclient.domain.usecases.GetMoviesUsecase
import com.akshay.tmdbclient.domain.usecases.UpdateArtistUseCase
import com.akshay.tmdbclient.domain.usecases.UpdateMoviesUseCase
import com.akshay.tmdbclient.presentation.artist.ArtistViewModelFactory
import com.akshay.tmdbclient.presentation.movie.MovieViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule {
    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(
        getMoviesUseCase: GetMoviesUsecase,
        updateMoviesUsecase: UpdateMoviesUseCase
    ): MovieViewModelFactory {
        return MovieViewModelFactory(
            getMoviesUseCase,
            updateMoviesUsecase
        )
    }

}