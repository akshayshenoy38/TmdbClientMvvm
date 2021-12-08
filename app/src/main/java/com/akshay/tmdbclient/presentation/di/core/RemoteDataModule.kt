package com.akshay.tmdbclient.presentation.di.core

import com.akshay.tmdbclient.data.api.TmdbService
import com.akshay.tmdbclient.data.repository.artist.datasource.ArtistRemoteDatasource
import com.akshay.tmdbclient.data.repository.artist.datasourceImpl.ArtistRemoteDataSourceImpl
import com.akshay.tmdbclient.data.repository.movie.datasource.MovieRemoteDatasource
import com.akshay.tmdbclient.data.repository.movie.datasourceimpl.MovieRemoteDataSourceImpl
import com.akshay.tmdbclient.data.repository.tvshow.datasource.TvShowRemoteDatasource
import com.akshay.tmdbclient.data.repository.tvshow.datasourceImpl.TvShowsRemoteDataSourceImpl

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apiKey:String) {

    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(tmdbService: TmdbService): MovieRemoteDatasource {
        return MovieRemoteDataSourceImpl(tmdbService,apiKey)
    }

    @Singleton
    @Provides
    fun provideTvShowRemoteDataSource(tmdbService: TmdbService): TvShowRemoteDatasource {
        return TvShowsRemoteDataSourceImpl(tmdbService,apiKey)
    }

    @Singleton
    @Provides
    fun provideArtistRemoteDataSource(tmdbService: TmdbService): ArtistRemoteDatasource {
        return ArtistRemoteDataSourceImpl(tmdbService,apiKey)
    }
}