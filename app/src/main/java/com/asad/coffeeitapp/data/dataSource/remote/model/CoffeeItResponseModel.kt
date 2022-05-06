package com.asad.coffeeitapp.data.dataSource.remote.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CoffeeItResponseModel(
    @Json(name = "_id")
    val id: String,
    @Json(name = "types")
    val typeResponseModels: List<TypeResponseModel>,
    @Json(name = "sizes")
    val sizeResponseModels: List<SizeResponseModel>,
    @Json(name = "extras")
    val extraResponseModels: List<ExtraResponseModel>,
)
