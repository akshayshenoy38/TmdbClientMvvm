package com.akshay.tmdbclient.data.repository.artist.datasourceImpl

import com.akshay.tmdbclient.data.api.TmdbService
import com.akshay.tmdbclient.data.model.artist.ArtistList
import com.akshay.tmdbclient.data.repository.artist.datasource.ArtistRemoteDatasource
import retrofit2.Response

class ArtistRemoteDataSourceImpl(private val tmdbService: TmdbService, private val apiKey:String):
    ArtistRemoteDatasource {

    override suspend fun getArtists(): Response<ArtistList> {
        return tmdbService.getPopularArtist(apiKey)
    }

}