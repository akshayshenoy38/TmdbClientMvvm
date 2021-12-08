package com.akshay.tmdbclient.presentation.di.tvshow

import com.akshay.tmdbclient.presentation.artist.ArtistActivity
import com.akshay.tmdbclient.presentation.tvShows.TvShowsActivity
import dagger.Subcomponent

@TvShowScope
@Subcomponent(modules = [TvShowModule::class])
interface TvShowSubComponent {

    fun inject(tvShowsActivity: TvShowsActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create():TvShowSubComponent
    }
}