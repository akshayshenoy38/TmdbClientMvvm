package com.akshay.tmdbclient

import android.app.Application
import com.akshay.tmdbclient.presentation.di.Injector
import com.akshay.tmdbclient.presentation.di.artist.ArtistSubComponent
import com.akshay.tmdbclient.presentation.di.core.*
import com.akshay.tmdbclient.presentation.di.movie.MovieSubComponent
import com.akshay.tmdbclient.presentation.di.tvshow.TvShowSubComponent

class App : Application(), Injector {
    private lateinit var appComponent:AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule(BuildConfig.BASE_URL))
            .remoteDataModule(RemoteDataModule(BuildConfig.API_KEY))
            .build()

    }

    override fun createMovieSubComponent(): MovieSubComponent {
        return appComponent.movieSubComponent().create()
    }

    override fun createTvShowSubComponent(): TvShowSubComponent {
        return appComponent.tvSubComponent().create()
    }

    override fun createArtistSubComponent(): ArtistSubComponent {
        return appComponent.artistSubComponent().create()
    }

}