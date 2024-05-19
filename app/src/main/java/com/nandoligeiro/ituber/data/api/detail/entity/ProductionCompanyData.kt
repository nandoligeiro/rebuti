package com.nandoligeiro.ituber.data.api.detail.entity

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ProductionCompanyData(
    val id: Int,
    val logo_path: String?,
    val name: String,
    val origin_country: String
)