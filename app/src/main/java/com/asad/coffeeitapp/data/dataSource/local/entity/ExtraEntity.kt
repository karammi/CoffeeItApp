package com.asad.coffeeitapp.data.dataSource.local.entity

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "extra_tbl")
data class ExtraEntity(
    @PrimaryKey(autoGenerate = false)
    val id: String,
    val name: String,

) {
    @Ignore
    val subSelectionEntities: List<SubSelectionEntity>? = null
}
