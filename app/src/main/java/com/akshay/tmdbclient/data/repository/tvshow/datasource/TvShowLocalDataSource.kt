package com.akshay.tmdbclient.data.repository.tvshow.datasource

import com.akshay.tmdbclient.data.model.movie.Movie
import com.akshay.tmdbclient.data.model.tvshow.TvShow

interface TvShowLocalDataSource {

    suspend fun getTvShowsFromDb():List<TvShow>
    suspend fun saveTvShowsToDb(tvShows:List<TvShow>)
    suspend fun clearAll()
}