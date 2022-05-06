package com.asad.coffeeitapp.domain.model

data class TypeModel(
    val id: String,
    val name: String,
    val sizes: List<String>,
    val extras: List<String>,
)
