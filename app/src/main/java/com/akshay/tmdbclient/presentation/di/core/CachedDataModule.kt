package com.akshay.tmdbclient.presentation.di.core

import com.akshay.tmdbclient.data.db.MovieDao
import com.akshay.tmdbclient.data.repository.artist.datasource.ArtistCacheDataSource
import com.akshay.tmdbclient.data.repository.artist.datasourceImpl.ArtistCacheDataSourceImpl
import com.akshay.tmdbclient.data.repository.movie.datasource.MovieCacheDataSource
import com.akshay.tmdbclient.data.repository.movie.datasourceimpl.MovieCacheDataSourceImpl
import com.akshay.tmdbclient.data.repository.movie.datasourceimpl.MovieLocalDataSourceImpl
import com.akshay.tmdbclient.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.akshay.tmdbclient.data.repository.tvshow.datasourceImpl.TvShowsCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CachedDataModule {

    @Singleton
    @Provides
    fun provideMovieCachedDataSource():MovieCacheDataSource {
        return MovieCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideTvShowCachedDataSource():TvShowCacheDataSource {
        return TvShowsCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideArtistCachedDataSource(): ArtistCacheDataSource {
        return ArtistCacheDataSourceImpl()
    }
}