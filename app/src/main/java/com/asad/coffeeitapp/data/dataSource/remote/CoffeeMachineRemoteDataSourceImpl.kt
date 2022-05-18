package com.asad.coffeeitapp.data.dataSource.remote

import com.asad.coffeeitapp.core.CustomErrorHandler
import com.asad.coffeeitapp.core.ErrorHandler
import com.asad.coffeeitapp.core.Result
import com.asad.coffeeitapp.data.dataSource.remote.model.CoffeeMachineResponseModel
import javax.inject.Inject

class CoffeeMachineRemoteDataSourceImpl @Inject constructor(
    private val coffeeMachineAPI: CoffeeMachineAPI,
    private val customErrorHandler: ErrorHandler,
) : CoffeeMachineRemoteDataSource {
    override suspend fun fetchCoffeeMachineInfo(id: String): Result<CoffeeMachineResponseModel> {
        return try {
            val response = coffeeMachineAPI.fetchCoffeeMachineInfo(id)
            Result.Success(response)
        } catch (e: Exception) {
            Result.Error(customErrorHandler.convertToApiErrorBody(e))
        }
    }

    override suspend fun checkDeviceConnection(): Result<String> {
        return try {
            val response = coffeeMachineAPI.checkDeviceConnection()
            Result.Success(response)
        } catch (ex: Exception) {
            Result.Error(customErrorHandler.convertToApiErrorBody(ex))
        }
    }
}
