package com.nandoligeiro.ituber.data.api.detail.entity

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class BelongsToCollectionData(

    val backdrop_path: String?,
    val id: Int,
    val name: String,
    val poster_path: String
)