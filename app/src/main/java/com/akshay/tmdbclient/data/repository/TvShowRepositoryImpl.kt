package com.akshay.tmdbclient.data.repository

import com.akshay.tmdbclient.data.model.movie.Movie
import com.akshay.tmdbclient.data.model.tvshow.TvShow
import com.akshay.tmdbclient.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.akshay.tmdbclient.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.akshay.tmdbclient.data.repository.tvshow.datasource.TvShowRemoteDatasource
import com.akshay.tmdbclient.domain.repository.TvShowRepository

class TvShowRepositoryImpl(private val tvShowRemoteDatasource: TvShowRemoteDatasource,
                           private val tvShowLocalDataSource: TvShowLocalDataSource,
                           private val tvShowCacheDataSource: TvShowCacheDataSource
):TvShowRepository {

    override suspend fun getTvShows(): List<TvShow>? {
        return getTvShowsFromCache()
    }

    override suspend fun updateTvShows(): List<TvShow>? {
        val newListOfTvShows = getTvShowsFromApi()
        tvShowLocalDataSource.clearAll()
        tvShowLocalDataSource.saveTvShowsToDb(newListOfTvShows)
        tvShowCacheDataSource.saveTvShowsToCache(newListOfTvShows)
        return newListOfTvShows
    }


    suspend fun getTvShowsFromApi() :List<TvShow> {
        lateinit var tvShowList:List<TvShow>
        try {
            val response = tvShowRemoteDatasource.getTvShows()
            val body = response.body()

            if (body != null) {
                 body.tvShows?.let {
                    tvShowList = it
                }
            }
        } catch (e:Exception) {

        }
        return tvShowList
    }


    suspend fun getTvShowsFromDb()  :List<TvShow>  {
        lateinit var tvShowsList:List<TvShow>
        try {
            tvShowsList = tvShowLocalDataSource.getTvShowsFromDb()


            if (tvShowsList.size>0) {
                return tvShowsList
            } else {
                tvShowsList = getTvShowsFromApi()
                tvShowLocalDataSource.saveTvShowsToDb(tvShowsList)
            }
        } catch (e:Exception) {

        }

        return tvShowsList

    }



    suspend fun getTvShowsFromCache():List<TvShow> {
        lateinit var tvShowList:List<TvShow>
        try {
            tvShowList = tvShowCacheDataSource.getTvShowsFromCache()


            if (tvShowList.size>0) {
                return tvShowList
            } else {
                tvShowList = getTvShowsFromApi()
                tvShowCacheDataSource.saveTvShowsToCache(tvShowList)
            }
        } catch (e:Exception) {

        }

        return tvShowList
    }


}