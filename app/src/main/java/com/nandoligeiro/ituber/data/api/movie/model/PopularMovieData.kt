package com.nandoligeiro.ituber.data.api.movie.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PopularMovieData(
    val page: Int,
    val results: List<PopularMovieResultData>,
    @Json(name = "total_pages")
    val totalPages: Int,
    @Json(name = "total_results")
    val totalResults: Int
)
