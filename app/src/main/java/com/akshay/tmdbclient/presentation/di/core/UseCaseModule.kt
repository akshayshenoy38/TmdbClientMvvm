package com.akshay.tmdbclient.presentation.di.core

import com.akshay.tmdbclient.domain.repository.ArtistRepository
import com.akshay.tmdbclient.domain.repository.MovieRepository
import com.akshay.tmdbclient.domain.repository.TvShowRepository
import com.akshay.tmdbclient.domain.usecases.*
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UseCaseModule {


    @Provides
    fun provideGetMovieUseCase(movieRepository: MovieRepository): GetMoviesUsecase {
        return GetMoviesUsecase(movieRepository)
    }


    @Provides
    fun provideUpdateMovieUseCase(movieRepository: MovieRepository): UpdateMoviesUseCase {
        return UpdateMoviesUseCase(movieRepository)
    }


    @Provides
    fun provideGetTvShowUseCase(tvShowRepository: TvShowRepository): GetTvShowsUseCase {
        return GetTvShowsUseCase(tvShowRepository)
    }


    @Provides
    fun provideUpdateTvShowUseCase(tvShowRepository: TvShowRepository): UpdateTvShowsUseCase {
        return UpdateTvShowsUseCase(tvShowRepository)
    }


    @Provides
    fun provideGetArtistUseCase(artistRepository: ArtistRepository): GetArtistsUseCase {
        return GetArtistsUseCase(artistRepository)
    }


    @Provides
    fun provideUpdateArtistUseCase(artistRepository: ArtistRepository): UpdateArtistUseCase {
        return UpdateArtistUseCase(artistRepository)
    }
}