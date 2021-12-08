package com.akshay.tmdbclient.domain.repository

import com.akshay.tmdbclient.data.model.movie.Movie
import com.akshay.tmdbclient.data.model.tvshow.TvShow

interface TvShowRepository {

    suspend fun getTvShows():List<TvShow>?
    suspend fun updateTvShows():List<TvShow>?
}