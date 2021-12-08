package com.akshay.tmdbclient.data.repository.tvshow.datasource

import com.akshay.tmdbclient.data.model.movie.MovieList
import com.akshay.tmdbclient.data.model.tvshow.TvShowList
import retrofit2.Response

interface TvShowRemoteDatasource {
    suspend fun getTvShows() : Response<TvShowList>
}