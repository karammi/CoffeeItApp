package com.asad.coffeeitapp.data.dataSource.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "sub_selection_tbl")
data class SubSelectionEntity(
    @PrimaryKey(autoGenerate = false)
    val id: String,
    val name: String,
)
