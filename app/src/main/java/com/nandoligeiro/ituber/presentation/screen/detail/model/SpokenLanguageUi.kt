package com.nandoligeiro.ituber.presentation.screen.detail.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SpokenLanguageUi(
    val english_name: String,
    val iso_639_1: String,
    val name: String
)