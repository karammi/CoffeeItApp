package com.asad.coffeeitapp.data.dataSource.remote.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TypeResponseModel(
    @Json(name = "_id")
    val id: String,
    val name: String,
    val sizes: List<String>,
    val extras: List<String>,
)
