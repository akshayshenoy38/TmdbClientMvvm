package com.akshay.tmdbclient.presentation.di

import com.akshay.tmdbclient.presentation.di.artist.ArtistSubComponent
import com.akshay.tmdbclient.presentation.di.movie.MovieSubComponent
import com.akshay.tmdbclient.presentation.di.tvshow.TvShowSubComponent

interface Injector {

    fun createMovieSubComponent():MovieSubComponent
    fun createTvShowSubComponent():TvShowSubComponent
    fun createArtistSubComponent():ArtistSubComponent
}