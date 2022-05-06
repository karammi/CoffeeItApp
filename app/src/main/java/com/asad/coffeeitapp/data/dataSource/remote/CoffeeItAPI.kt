package com.asad.coffeeitapp.data.dataSource.remote

import retrofit2.http.GET
import retrofit2.http.Path

interface CoffeeItAPI {

    @GET("/")
    suspend fun checkDeviceConnection()

    @GET("/coffee_machine/{id}")
    suspend fun syncCoffeeMachine(@Path("id") id: Int)
}
