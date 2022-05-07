package com.asad.coffeeitapp.data.dataSource.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.asad.coffeeitapp.data.dataSource.local.util.CoffeeMachineConstants

@Entity(tableName = CoffeeMachineConstants.TABLE_NAME)
data class CoffeeMachineEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = CoffeeMachineConstants.COFFEE_MACHINE_ID)
    val id: String,
    val typeEntities: List<TypeEntity>,
    val sizeEntities: List<SizeEntity>,
    val extraEntities: List<ExtraEntity>,
)
