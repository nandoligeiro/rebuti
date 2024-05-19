package com.nandoligeiro.ituber.data.api.detail.entity

import com.nandoligeiro.ituber.presentation.common.NullToEmptyString
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DetailMovieData(
    val adult: Boolean,
    val backdrop_path: String?,
    val belongs_to_collection: BelongsToCollectionData?,
    val budget: Int,
    val genres: List<GenreData>,
    val homepage: String,
    val id: Int,
    val imdb_id: String?,
    val origin_country: List<String>,
    val original_language: String,
    val original_title: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val production_companies: List<ProductionCompanyData>,
    val production_countries: List<ProductionCountryData>,
    val release_date: String,
    val revenue: Int,
    val runtime: Int,
    val spoken_languages: List<SpokenLanguageData>,
    val status: String,
    val tagline: String,
    val title: String,
    val video: Boolean,
    val vote_average: Double,
    val vote_count: Int
)