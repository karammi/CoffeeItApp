package com.asad.coffeeitapp.data.dataSource.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.asad.coffeeitapp.data.dataSource.local.util.CoffeeMachineConstants

@Entity(tableName = CoffeeMachineConstants.TABLE_NAME)
data class CoffeeMachineEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = CoffeeMachineConstants.COFFEE_MACHINE_ID)
    val id: String,
) {
    @Ignore
    @Transient
    val typeEntities: List<TypeEntity>? = null

    @Ignore
    @Transient
    val sizeEntities: List<SizeEntity>? = null

    @Ignore
    @Transient
    val extraEntities: List<ExtraEntity>? = null
}
