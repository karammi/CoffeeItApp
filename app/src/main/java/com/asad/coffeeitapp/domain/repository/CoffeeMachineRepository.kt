package com.asad.coffeeitapp.domain.repository

import com.asad.coffeeitapp.domain.model.CoffeeMachineModel

interface CoffeeMachineRepository {
    suspend fun fetchCoffeeMachineInfo(id: String): Result<CoffeeMachineModel>
}
