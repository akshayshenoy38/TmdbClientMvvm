package com.akshay.tmdbclient.presentation.di.core

import com.akshay.tmdbclient.data.db.ArtistDao
import com.akshay.tmdbclient.data.db.MovieDao
import com.akshay.tmdbclient.data.db.TvDao
import com.akshay.tmdbclient.data.repository.artist.datasource.ArtistLocalDataSource
import com.akshay.tmdbclient.data.repository.artist.datasourceImpl.ArtistLocalDataSourceImpl
import com.akshay.tmdbclient.data.repository.movie.datasource.MovieLocalDataSource
import com.akshay.tmdbclient.data.repository.movie.datasourceimpl.MovieLocalDataSourceImpl
import com.akshay.tmdbclient.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.akshay.tmdbclient.data.repository.tvshow.datasourceImpl.TvShowsLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun provideMovieDataSource(movieDao: MovieDao):MovieLocalDataSource {
        return MovieLocalDataSourceImpl(movieDao)
    }

    @Singleton
    @Provides
    fun provideTvDataSource(tvDao: TvDao):TvShowLocalDataSource {
        return TvShowsLocalDataSourceImpl(tvDao)
    }

    @Singleton
    @Provides
    fun provideArtistLocalDataSource(artistDao: ArtistDao):ArtistLocalDataSource {
        return ArtistLocalDataSourceImpl(artistDao)
    }
}