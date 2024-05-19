package com.nandoligeiro.ituber.presentation.screen.detail.model

import com.squareup.moshi.JsonClass
@JsonClass(generateAdapter = true)
data class BelongsToCollectionUi(
    val backdrop_path: String = "",
    val id: Int = 0,
    val name: String = "",
    val poster_path: String = ""
)