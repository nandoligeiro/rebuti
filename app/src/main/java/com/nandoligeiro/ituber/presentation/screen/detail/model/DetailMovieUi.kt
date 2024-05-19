package com.nandoligeiro.ituber.presentation.screen.detail.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DetailMovieUi(
    val adult: Boolean = false,
    val backdrop_path: String = "",
    val belongs_to_collection: BelongsToCollectionUi = BelongsToCollectionUi(),
    val budget: Int = 0,
    val genres: List<GenreUi> = listOf(),
    val homepage: String = "",
    val id: Int = 0,
    val imdb_id: String = "",
    val origin_country: List<String> = listOf(),
    val original_language: String = "",
    val original_title: String = "",
    val overview: String = "",
    val popularity: Double = 0.0,
    val poster_path: String = "",
    val production_companies: List<ProductionCompanyUi> = listOf(),
    val production_countries: List<ProductionCountryUi> = listOf(),
    val release_date: String = "",
    val revenue: Int = 0,
    val runtime: Int = 0,
    val spoken_languages: List<SpokenLanguageUi> = listOf(),
    val status: String = "",
    val tagline: String = "",
    val title: String = "",
    val video: Boolean = false,
    val vote_average: Double = 0.0,
    val vote_count: Int = 0
)