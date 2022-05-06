package com.asad.coffeeitapp.data.dataSource.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "size_tbl")
data class SizeEntity(
    @PrimaryKey(autoGenerate = false)
    val id: String,
    val name: String,
    val v: Int? = null,
)
