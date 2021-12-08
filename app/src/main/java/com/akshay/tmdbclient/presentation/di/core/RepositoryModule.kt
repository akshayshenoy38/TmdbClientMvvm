package com.akshay.tmdbclient.presentation.di.core

import com.akshay.tmdbclient.data.repository.ArtistRepositoryImpl
import com.akshay.tmdbclient.data.repository.MovieRepositoryImpl
import com.akshay.tmdbclient.data.repository.TvShowRepositoryImpl
import com.akshay.tmdbclient.data.repository.artist.datasource.ArtistCacheDataSource
import com.akshay.tmdbclient.data.repository.artist.datasource.ArtistLocalDataSource
import com.akshay.tmdbclient.data.repository.artist.datasource.ArtistRemoteDatasource
import com.akshay.tmdbclient.data.repository.movie.datasource.MovieCacheDataSource
import com.akshay.tmdbclient.data.repository.movie.datasource.MovieLocalDataSource
import com.akshay.tmdbclient.data.repository.movie.datasource.MovieRemoteDatasource
import com.akshay.tmdbclient.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.akshay.tmdbclient.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.akshay.tmdbclient.data.repository.tvshow.datasource.TvShowRemoteDatasource
import com.akshay.tmdbclient.domain.repository.ArtistRepository
import com.akshay.tmdbclient.domain.repository.MovieRepository
import com.akshay.tmdbclient.domain.repository.TvShowRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideMovieRepository(
       movieRemoteDatasource: MovieRemoteDatasource,
       movieLocalDataSource: MovieLocalDataSource,
       movieCacheDataSource: MovieCacheDataSource
    ): MovieRepository {
        return MovieRepositoryImpl(movieRemoteDatasource, movieLocalDataSource,movieCacheDataSource)
    }


    @Singleton
    @Provides
    fun provideTvShowRepository(
        tvShowRemoteDatasource: TvShowRemoteDatasource,
        tvShowLocalDataSource: TvShowLocalDataSource,
        tvShowCacheDataSource: TvShowCacheDataSource
    ): TvShowRepository {
        return TvShowRepositoryImpl(tvShowRemoteDatasource, tvShowLocalDataSource,tvShowCacheDataSource)
    }


    @Singleton
    @Provides
    fun provideArtistsRepository(
        artistsRemoteDatasource: ArtistRemoteDatasource,
        artistsLocalDataSource: ArtistLocalDataSource,
       artistCacheDataSource: ArtistCacheDataSource
    ): ArtistRepository {
        return ArtistRepositoryImpl(artistsRemoteDatasource, artistsLocalDataSource,artistCacheDataSource)
    }
}