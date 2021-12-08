package com.akshay.tmdbclient.presentation.di.core

import com.akshay.tmdbclient.presentation.di.artist.ArtistSubComponent
import com.akshay.tmdbclient.presentation.di.movie.MovieSubComponent
import com.akshay.tmdbclient.presentation.di.tvshow.TvShowSubComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,
CachedDataModule::class,
DatabaseModule::class,
LocalDataModule::class,
NetModule::class,
RemoteDataModule::class,
RepositoryModule::class,
UseCaseModule::class
])
interface AppComponent {

    fun movieSubComponent():MovieSubComponent.Factory
    fun tvSubComponent():TvShowSubComponent.Factory
    fun artistSubComponent():ArtistSubComponent.Factory




}