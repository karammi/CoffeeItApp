package com.asad.coffeeitapp.data.dataSource.remote.model

import com.asad.coffeeitapp.domain.model.*
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CoffeeMachineResponseModel(
    @Json(name = "_id")
    val id: String,
    @Json(name = "types")
    val typeResponseModels: List<TypeResponseModel>,
    @Json(name = "sizes")
    val sizeResponseModels: List<SizeResponseModel>,
    @Json(name = "extras")
    val extraResponseModels: List<ExtraResponseModel>,
)

fun CoffeeMachineResponseModel.mapper(): CoffeeMachineModel =
    with(this) {
        CoffeeMachineModel(
            id,
            typeModels = this.typeResponseModels.map {
                it.mapper()
            },
            sizeModels = this.sizeResponseModels.map {
                it.mapper()
            },
            extraModels = this.extraResponseModels.map {
                it.mapper()
            }
        )
    }

fun TypeResponseModel.mapper(): TypeModel =
    with(this) {
        TypeModel(id, name, sizes, extras)
    }

fun SizeResponseModel.mapper(): SizeModel =
    with(this) {
        SizeModel(id, name, v)
    }

fun ExtraResponseModel.mapper(): ExtraModel =
    with(this) {
        ExtraModel(
            id, name,
            subSelectionModels = this.subSelectionResponseModels.map {
                it.mapper()
            }
        )
    }

fun SubSelectionResponseModel.mapper(): SubSelectionModel =
    with(this) {
        SubSelectionModel(id, name)
    }
