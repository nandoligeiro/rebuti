package com.nandoligeiro.ituber.presentation.screen.detail.model

import com.squareup.moshi.JsonClass
@JsonClass(generateAdapter = true)
data class ProductionCompanyUi(
    val id: Int,
    val logo_path: String,
    val name: String,
    val origin_country: String
)