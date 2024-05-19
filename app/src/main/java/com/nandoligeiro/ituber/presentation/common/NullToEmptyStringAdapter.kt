package com.nandoligeiro.ituber.presentation.common

import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonQualifier
import com.squareup.moshi.ToJson
import javax.annotation.Nullable

@Retention(AnnotationRetention.RUNTIME)
@JsonQualifier
annotation class NullToEmptyString
class NullToEmptyStringAdapter {
    @FromJson
    @NullToEmptyString
    fun fromJson(@Nullable data: String?): String {
        return data ?: ""
    }

    @ToJson
    fun toJson(@NullToEmptyString data: String?): String? {
        return data
    }
}
