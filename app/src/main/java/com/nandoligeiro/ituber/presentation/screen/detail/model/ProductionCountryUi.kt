package com.nandoligeiro.ituber.presentation.screen.detail.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ProductionCountryUi(
    val iso_3166_1: String,
    val name: String
)