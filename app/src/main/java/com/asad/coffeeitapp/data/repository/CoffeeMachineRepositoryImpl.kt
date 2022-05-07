package com.asad.coffeeitapp.data.repository

import com.asad.coffeeitapp.domain.model.CoffeeMachineModel
import com.asad.coffeeitapp.domain.repository.CoffeeMachineRepository
import javax.inject.Inject

class CoffeeMachineRepositoryImpl @Inject constructor() : CoffeeMachineRepository {
    override suspend fun fetchCoffeeMachineInfo(id: String): Result<CoffeeMachineModel> {
        TODO("Not yet implemented")
    }
}
