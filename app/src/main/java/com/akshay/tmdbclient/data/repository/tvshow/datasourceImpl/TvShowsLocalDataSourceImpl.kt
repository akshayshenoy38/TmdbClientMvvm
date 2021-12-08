package com.akshay.tmdbclient.data.repository.tvshow.datasourceImpl

import com.akshay.tmdbclient.data.db.TvDao
import com.akshay.tmdbclient.data.model.tvshow.TvShow
import com.akshay.tmdbclient.data.repository.tvshow.datasource.TvShowLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TvShowsLocalDataSourceImpl(private val tvDao: TvDao): TvShowLocalDataSource {

    override suspend fun getTvShowsFromDb(): List<TvShow> {
        return tvDao.getTvShows()
    }

    override suspend fun saveTvShowsToDb(tvShows: List<TvShow>) {
        CoroutineScope(Dispatchers.IO).launch {
            tvDao.saveTvShows(tvShows)
        }
    }

    override suspend fun clearAll() {
        tvDao.deleteAllTvShows()
    }
}