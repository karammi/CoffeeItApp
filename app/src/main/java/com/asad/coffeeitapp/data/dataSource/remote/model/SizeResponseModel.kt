package com.asad.coffeeitapp.data.dataSource.remote.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SizeResponseModel(
    @Json(name = "_id")
    val id: String,
    val name: String,
    @Json(name = "__v")
    val v: Int? = null,
)
