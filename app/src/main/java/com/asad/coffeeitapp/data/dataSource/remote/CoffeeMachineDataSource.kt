package com.asad.coffeeitapp.data.dataSource.remote

import com.asad.coffeeitapp.data.dataSource.remote.model.CoffeeMachineResponseModel

interface CoffeeMachineDataSource {

    suspend fun fetchCoffeeMachineInfo(id: String): Result<CoffeeMachineResponseModel>
}
