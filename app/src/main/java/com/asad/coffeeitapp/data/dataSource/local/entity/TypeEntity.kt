package com.asad.coffeeitapp.data.dataSource.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "type_tbl")
data class TypeEntity(
    @PrimaryKey(autoGenerate = false)
    val id: String,
    val name: String,
    val sizes: List<String>? = null,
    val extras: List<String>? = null,
)

@Entity(tableName = "type_size_tbl", primaryKeys = ["typeId", "sizeId"], foreignKeys = [])
data class TypeWithSizeRelationEntity(
    @PrimaryKey(autoGenerate = false)
    private val typeId: String,
    @PrimaryKey(autoGenerate = false)
    private val sizeId: String,
)

@Entity(
    tableName = "type_extra_tbl", primaryKeys = ["typeId", "extraId"], foreignKeys = [])
data class TypeWithExtraRelationEntity(
    @PrimaryKey(autoGenerate = false)
    private val typeId: String,
    @PrimaryKey(autoGenerate = false)
    private val extraId: String,
)