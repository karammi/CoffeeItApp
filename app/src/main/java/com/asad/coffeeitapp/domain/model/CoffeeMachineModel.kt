package com.asad.coffeeitapp.domain.model

data class CoffeeMachineModel(
    val id: String,
    val typeModels: List<TypeModel>,
    val sizeModels: List<SizeModel>,
    val extraModels: List<ExtraModel>,
)
