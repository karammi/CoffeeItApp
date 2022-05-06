package com.asad.coffeeitapp.data.dataSource.remote.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ExtraResponseModel(
    @Json(name = "_id")
    val id: String,
    val name: String,
    @Json(name = "subselections")
    val subSelectionResponseModels: List<SubSelectionResponseModel>,
)
