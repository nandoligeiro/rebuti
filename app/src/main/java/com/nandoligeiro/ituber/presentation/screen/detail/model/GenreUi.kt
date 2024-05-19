package com.nandoligeiro.ituber.presentation.screen.detail.model

import com.squareup.moshi.JsonClass
@JsonClass(generateAdapter = true)
data class GenreUi(
    val id: Int = 0,
    val name: String = ""
)