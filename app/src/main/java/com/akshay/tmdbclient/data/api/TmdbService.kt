package com.akshay.tmdbclient.data.api

import com.akshay.tmdbclient.data.model.artist.ArtistList
import com.akshay.tmdbclient.data.model.movie.MovieList
import com.akshay.tmdbclient.data.model.tvshow.TvShowList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TmdbService {
    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("api_key") apiKey:String) : Response<MovieList>

    @GET("tv/popular")
    suspend fun getPopularTvShows(@Query("api_key") apiKey:String) : Response<TvShowList>

    @GET("person/popular")
    suspend fun getPopularArtist(@Query("api_key") apiKey:String) : Response<ArtistList>
}