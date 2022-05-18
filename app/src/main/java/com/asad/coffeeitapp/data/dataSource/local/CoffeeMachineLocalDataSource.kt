package com.asad.coffeeitapp.data.dataSource.local

import com.asad.coffeeitapp.data.dataSource.local.entity.CoffeeMachineEntity

interface CoffeeMachineLocalDataSource {
    suspend fun insertCoffeeMachine(coffeeMachineEntity: CoffeeMachineEntity)
}
