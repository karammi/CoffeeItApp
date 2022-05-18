package com.asad.coffeeitapp.data.dataSource.remote

import com.asad.coffeeitapp.core.Result
import com.asad.coffeeitapp.data.dataSource.remote.model.CoffeeMachineResponseModel

interface CoffeeMachineRemoteDataSource {

    suspend fun fetchCoffeeMachineInfo(id: String): Result<CoffeeMachineResponseModel>

    suspend fun checkDeviceConnection(): Result<String>
}
