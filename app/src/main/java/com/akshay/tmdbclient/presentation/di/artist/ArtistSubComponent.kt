package com.akshay.tmdbclient.presentation.di.artist

import com.akshay.tmdbclient.presentation.artist.ArtistActivity
import dagger.Subcomponent
@ArtistScope
@Subcomponent(modules = [ArtistModule::class])
interface ArtistSubComponent {

    fun inject(artistActivity: ArtistActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create():ArtistSubComponent
    }
}