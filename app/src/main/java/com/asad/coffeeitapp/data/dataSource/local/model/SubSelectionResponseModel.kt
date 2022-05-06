package com.asad.coffeeitapp.data.dataSource.local.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SubSelectionResponseModel(
    @Json(name = "_id")
    val id: String,
    val name: String,
)
