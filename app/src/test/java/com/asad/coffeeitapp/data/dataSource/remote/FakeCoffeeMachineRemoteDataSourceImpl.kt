package com.asad.coffeeitapp.data.dataSource.remote

import com.asad.coffeeitapp.core.Result
import com.asad.coffeeitapp.data.dataSource.remote.model.CoffeeMachineResponseModel

class FakeCoffeeMachineRemoteDataSourceImpl : CoffeeMachineRemoteDataSource {

    private val currentCoffeeMachineData = ACTUAL_VALUE
    override suspend fun fetchCoffeeMachineInfo(id: String): Result<CoffeeMachineResponseModel> {
        return Result.Success(data = currentCoffeeMachineData)
    }

    override suspend fun checkDeviceConnection(): Result<String> {
        TODO("Not yet implemented")
    }
}
