package com.akshay.tmdbclient.data.repository.tvshow.datasourceImpl

import com.akshay.tmdbclient.data.api.TmdbService
import com.akshay.tmdbclient.data.model.tvshow.TvShowList
import com.akshay.tmdbclient.data.repository.tvshow.datasource.TvShowRemoteDatasource
import retrofit2.Response

class TvShowsRemoteDataSourceImpl(private val tmdbService: TmdbService, private val apiKey:String):
    TvShowRemoteDatasource {


    override suspend fun getTvShows(): Response<TvShowList> {
        return tmdbService.getPopularTvShows(apiKey)
    }

}