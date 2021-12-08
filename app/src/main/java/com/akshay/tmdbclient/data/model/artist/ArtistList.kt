package com.akshay.tmdbclient.data.model.artist


import com.google.gson.annotations.SerializedName


data class ArtistList(
    @SerializedName("page")
    var page: Int?,
    @SerializedName("results")
    var results: List<Artist>?,
    @SerializedName("total_pages")
    var totalPages: Int?,
    @SerializedName("total_results")
    var totalResults: Int?
)