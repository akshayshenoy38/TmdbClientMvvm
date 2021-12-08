package com.akshay.tmdbclient.data.repository

import com.akshay.tmdbclient.data.model.artist.Artist
import com.akshay.tmdbclient.data.repository.artist.datasource.ArtistCacheDataSource
import com.akshay.tmdbclient.data.repository.artist.datasource.ArtistLocalDataSource
import com.akshay.tmdbclient.data.repository.artist.datasource.ArtistRemoteDatasource
import com.akshay.tmdbclient.domain.repository.ArtistRepository

class ArtistRepositoryImpl(private val artistRemoteDatasource: ArtistRemoteDatasource,
    private val artistLocalDataSource: ArtistLocalDataSource,
                           private val artistCacheDataSource: ArtistCacheDataSource
):ArtistRepository {

    override suspend fun getArtists(): List<Artist>? {
        return getArtistsFromCache()
    }

    override suspend fun updateArtists(): List<Artist>? {
        val newListOfArtists = getArtistsFromApis()
        artistLocalDataSource.clearAll()
        artistLocalDataSource.saveArtistsToDb(newListOfArtists)
        artistCacheDataSource.saveArtistsToCache(newListOfArtists)
        return newListOfArtists
    }


    suspend fun getArtistsFromApis() :List<Artist> {
        lateinit var artistList:List<Artist>
        try {
            val response = artistRemoteDatasource.getArtists()
            val body = response.body()

            if (body != null) {
                body.results?.let {
                    artistList = it
                }

            }
        } catch (e:Exception) {

        }
        return artistList
    }


    suspend fun getArtistsFromDb()  :List<Artist>  {
        lateinit var artistList:List<Artist>
        try {
            artistList = artistLocalDataSource.getArtistsFromDb()


            if (artistList.size>0) {
                return artistList
            } else {
                artistList = getArtistsFromApis()
                artistLocalDataSource.saveArtistsToDb(artistList)
            }
        } catch (e:Exception) {

        }

        return artistList

    }



    suspend fun getArtistsFromCache():List<Artist> {
        lateinit var artistList:List<Artist>
        try {
            artistList = artistCacheDataSource.getArtistFromCache()


            if (artistList.size>0) {
                return artistList
            } else {
                artistList = getArtistsFromApis()
                artistCacheDataSource.saveArtistsToCache(artistList)
            }
        } catch (e:Exception) {

        }

        return artistList
    }


}