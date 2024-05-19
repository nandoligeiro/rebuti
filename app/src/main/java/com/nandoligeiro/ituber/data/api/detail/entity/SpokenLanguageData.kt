package com.nandoligeiro.ituber.data.api.detail.entity

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SpokenLanguageData(
    val english_name: String,
    val iso_639_1: String,
    val name: String
)