package com.nandoligeiro.ituber.presentation.common

import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson

class NullToEmptyListAdapter {
    @FromJson
    fun fromJson(data: List<Any>?): List<Any> {
        return data ?: emptyList()
    }

    @ToJson
    fun toJson(data: List<Any>?): List<Any>? {
        return data
    }
}
