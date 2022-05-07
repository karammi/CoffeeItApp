package com.asad.coffeeitapp.data.dataSource.remote

import com.asad.coffeeitapp.data.dataSource.remote.model.CoffeeMachineResponseModel
import retrofit2.http.GET
import retrofit2.http.Path

interface CoffeeMachineAPI {

    @GET("/")
    suspend fun checkDeviceConnection()

    @GET("/coffee_machine/{id}")
    suspend fun fetchCoffeeMachineInfo(@Path("id") id: String): CoffeeMachineResponseModel
}
