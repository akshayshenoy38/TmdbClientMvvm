package com.akshay.tmdbclient.data.repository.artist.datasourceImpl

import com.akshay.tmdbclient.data.model.artist.Artist
import com.akshay.tmdbclient.data.repository.artist.datasource.ArtistCacheDataSource

class ArtistCacheDataSourceImpl: ArtistCacheDataSource {
    private var artistList = ArrayList<Artist>()

    override suspend fun getArtistFromCache(): List<Artist> {
        return artistList
    }

    override suspend fun saveArtistsToCache(artists: List<Artist>) {
        artistList.clear()
        artistList = ArrayList(artists)
    }
}