package com.akshay.tmdbclient.data.repository.tvshow.datasource

import com.akshay.tmdbclient.data.model.movie.Movie
import com.akshay.tmdbclient.data.model.tvshow.TvShow

interface TvShowCacheDataSource {

    suspend fun getTvShowsFromCache():List<TvShow>

    suspend fun saveTvShowsToCache(tvShows:List<TvShow>)
}