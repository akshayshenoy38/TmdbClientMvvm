package com.akshay.tmdbclient.presentation.di.artist

import com.akshay.tmdbclient.domain.usecases.GetArtistsUseCase
import com.akshay.tmdbclient.domain.usecases.UpdateArtistUseCase
import com.akshay.tmdbclient.presentation.artist.ArtistViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ArtistModule {

    @ArtistScope
    @Provides
    fun providesArtistViewModelFactory(
        getArtistsUseCase: GetArtistsUseCase,
        updateArtistUseCase: UpdateArtistUseCase
    ):ArtistViewModelFactory {

        return ArtistViewModelFactory(getArtistsUseCase,updateArtistUseCase)

    }
}