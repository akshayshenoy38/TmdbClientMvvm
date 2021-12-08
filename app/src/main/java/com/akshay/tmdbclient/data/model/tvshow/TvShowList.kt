package com.akshay.tmdbclient.data.model.tvshow


import com.google.gson.annotations.SerializedName

data class TvShowList(
    @SerializedName("page")
    var page: Int?,
    @SerializedName("results")
    var tvShows: List<TvShow>?
)