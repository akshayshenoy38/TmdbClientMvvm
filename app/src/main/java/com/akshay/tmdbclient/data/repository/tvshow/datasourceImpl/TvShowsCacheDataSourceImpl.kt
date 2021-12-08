package com.akshay.tmdbclient.data.repository.tvshow.datasourceImpl

import com.akshay.tmdbclient.data.model.tvshow.TvShow
import com.akshay.tmdbclient.data.repository.tvshow.datasource.TvShowCacheDataSource

class TvShowsCacheDataSourceImpl: TvShowCacheDataSource {
    private var tvShowsList = ArrayList<TvShow>()


    override suspend fun getTvShowsFromCache(): List<TvShow> {
        return tvShowsList
    }

    override suspend fun saveTvShowsToCache(tvShows: List<TvShow>) {
        tvShowsList.clear()
        tvShowsList = ArrayList(tvShows)

    }
}