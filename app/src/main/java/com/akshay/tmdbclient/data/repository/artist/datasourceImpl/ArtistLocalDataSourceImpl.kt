package com.akshay.tmdbclient.data.repository.artist.datasourceImpl

import com.akshay.tmdbclient.data.db.ArtistDao
import com.akshay.tmdbclient.data.model.artist.Artist
import com.akshay.tmdbclient.data.repository.artist.datasource.ArtistLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ArtistLocalDataSourceImpl(private val artistDao: ArtistDao): ArtistLocalDataSource {

    override suspend fun getArtistsFromDb(): List<Artist> {
        return artistDao.getAllArtists()
    }

    override suspend fun saveArtistsToDb(artists: List<Artist>) {
        CoroutineScope(Dispatchers.IO).launch {
            artistDao.saveArtists(artists)
        }
    }

    override suspend fun clearAll() {
        artistDao.deleteAllArtists()
    }
}