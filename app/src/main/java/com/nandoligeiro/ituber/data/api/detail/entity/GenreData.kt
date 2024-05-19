package com.nandoligeiro.ituber.data.api.detail.entity

import com.squareup.moshi.JsonClass
@JsonClass(generateAdapter = true)
data class GenreData(
    val id: Int,
    val name: String
)