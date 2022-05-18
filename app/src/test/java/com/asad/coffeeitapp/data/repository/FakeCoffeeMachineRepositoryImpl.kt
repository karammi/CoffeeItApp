package com.asad.coffeeitapp.data.repository

import com.asad.coffeeitapp.coffee.COFFEE_MACHINE_FAKE
import com.asad.coffeeitapp.core.Result
import com.asad.coffeeitapp.domain.model.CoffeeMachineModel
import com.asad.coffeeitapp.domain.repository.CoffeeMachineRepository

class FakeCoffeeMachineRepositoryImpl : CoffeeMachineRepository {

    override suspend fun fetchCoffeeMachineInfo(id: String): Result<CoffeeMachineModel> {
        return Result.Success(COFFEE_MACHINE_FAKE)
    }

    override suspend fun checkDeviceConnection(): Result<String> {
        return Result.Success("welcome to coffee machine app")
    }
}
