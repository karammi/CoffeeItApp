package com.asad.coffeeitapp.domain.model

data class ExtraModel(
    val id: String,
    val name: String,
    val subSelectionModels: List<SubSelectionModel>,
)
