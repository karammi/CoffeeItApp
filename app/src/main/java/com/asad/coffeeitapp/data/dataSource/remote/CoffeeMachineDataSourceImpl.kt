package com.asad.coffeeitapp.data.dataSource.remote

import com.asad.coffeeitapp.data.dataSource.remote.model.CoffeeMachineResponseModel
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class CoffeeMachineDataSourceImpl @Inject constructor(
    private val coffeeMachineAPI: CoffeeMachineAPI,
) : CoffeeMachineDataSource {
    override suspend fun fetchCoffeeMachineInfo(id: String): Result<CoffeeMachineResponseModel> {
        return try {
            val response = coffeeMachineAPI.fetchCoffeeMachineInfo(id = id)
            Result.success(response)
        } catch (ex: Exception) {
            Result.failure(exception = ex)
        }
    }
}
