package com.nandoligeiro.ituber.data.api.detail.entity

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ProductionCountryData(
    val iso_3166_1: String,
    val name: String
)