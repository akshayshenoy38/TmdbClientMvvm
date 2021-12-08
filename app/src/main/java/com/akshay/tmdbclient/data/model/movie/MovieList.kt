package com.akshay.tmdbclient.data.model.movie


import com.google.gson.annotations.SerializedName

data class MovieList(
    @SerializedName("page")
    var page: Int?,
    @SerializedName("results")
    var movies: List<Movie>

)