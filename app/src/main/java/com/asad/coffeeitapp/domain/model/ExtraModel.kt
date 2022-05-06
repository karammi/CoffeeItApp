package com.asad.coffeeitapp.data.dataSource.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "extra_tbl")
data class ExtraEntity(
    @PrimaryKey(autoGenerate = false)
    val id: String,
    val name: String,
    val subSelectionEntities: List<SubSelectionEntity>,
)
