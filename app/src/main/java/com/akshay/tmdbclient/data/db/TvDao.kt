package com.akshay.tmdbclient.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

import com.akshay.tmdbclient.data.model.tvshow.TvShow


@Dao
interface TvDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTvShows(tvShows: List<TvShow>)


    @Query("DELETE FROM popular_tvshows")
    suspend fun deleteAllTvShows()

    @Query("SELECT * FROM popular_tvshows")
    suspend fun getTvShows():List<TvShow>
}