package com.asad.coffeeitapp.data.dataSource.local.entity

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "type_tbl")
data class TypeEntity(
    @PrimaryKey(autoGenerate = false)
    val id: String,
    val name: String,
) {
    @Ignore
    val sizes: List<String>? = null

    @Ignore
    val extras: List<String>? = null
}
