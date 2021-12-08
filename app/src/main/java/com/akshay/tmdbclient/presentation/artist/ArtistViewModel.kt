package com.akshay.tmdbclient.presentation.artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.akshay.tmdbclient.data.model.artist.Artist
import com.akshay.tmdbclient.data.model.movie.Movie
import com.akshay.tmdbclient.domain.usecases.GetArtistsUseCase
import com.akshay.tmdbclient.domain.usecases.GetMoviesUsecase
import com.akshay.tmdbclient.domain.usecases.UpdateArtistUseCase
import com.akshay.tmdbclient.domain.usecases.UpdateMoviesUseCase

class ArtistViewModel(
    private val getArtistsUseCase: GetArtistsUseCase,
    private val updateArtistUseCase: UpdateArtistUseCase
):ViewModel() {

    fun getArtists() = liveData<List<Artist>?> {
        val artistList = getArtistsUseCase.execute()
        emit(artistList)
    }

    fun updateArtists() = liveData<List<Artist>?> {
        val artistList = updateArtistUseCase.execute()
        emit(artistList)
    }
}