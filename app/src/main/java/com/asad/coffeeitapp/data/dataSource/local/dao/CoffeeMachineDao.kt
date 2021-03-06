package com.asad.coffeeitapp.data.dataSource.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.asad.coffeeitapp.data.dataSource.local.entity.CoffeeMachineEntity
import com.asad.coffeeitapp.data.dataSource.local.util.CoffeeMachineConstants

@Dao
interface CoffeeMachineDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCoffeeMachine(coffeeMachineEntity: CoffeeMachineEntity)

    @Delete
    suspend fun deleteCoffeeMachine(coffeeMachineEntity: CoffeeMachineEntity)

    @Query("SELECT * FROM ${CoffeeMachineConstants.TABLE_NAME} WHERE ${CoffeeMachineConstants.COFFEE_MACHINE_ID} = :id")
    suspend fun fetchCoffeeMachine(id: Int): CoffeeMachineEntity
}
