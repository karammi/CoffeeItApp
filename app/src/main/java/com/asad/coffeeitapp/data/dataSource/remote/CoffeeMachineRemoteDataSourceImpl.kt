package com.asad.coffeeitapp.data.dataSource.remote

import com.asad.coffeeitapp.core.ApiErrorBody
import com.asad.coffeeitapp.core.Result
import com.asad.coffeeitapp.data.dataSource.remote.model.CoffeeMachineResponseModel
import okhttp3.ResponseBody
import retrofit2.Converter
import retrofit2.HttpException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import javax.inject.Inject

class CoffeeMachineRemoteDataSourceImpl @Inject constructor(
    private val coffeeMachineAPI: CoffeeMachineAPI,
    private val converter: Converter<ResponseBody, ApiErrorBody>,
) : CoffeeMachineRemoteDataSource {
    override suspend fun fetchCoffeeMachineInfo(id: String): Result<CoffeeMachineResponseModel> {
        return try {
            val response = coffeeMachineAPI.fetchCoffeeMachineInfo(id)
            Result.Success(response)
        } catch (e: Exception) {
            val error = when (e) {
                is HttpException -> {
                    var apiErrorBody: ApiErrorBody? = null
                    e.response()?.errorBody()?.let {
                        apiErrorBody = converter.convert(it)
                    }
                    if (apiErrorBody != null) {
                        apiErrorBody
                    } else {
                        ApiErrorBody(message = "ConnectionError")
                    }
                }
//                is IOException -> {
//                    ApiErrorBody(message = "IO Exception")
//                }
                is SocketTimeoutException -> {
                    ApiErrorBody(message = "Socket TimeoutException")
                }
                is UnknownHostException -> {
                    ApiErrorBody(message = e.message, error = e.localizedMessage)
                }
                else -> {
                    ApiErrorBody(message = "Unknown Error")
                }
            }
            Result.Error(error!!)
        }
    }

    override suspend fun checkDeviceConnection(): Result<String> {
        return try {
            val response = coffeeMachineAPI.checkDeviceConnection()
            Result.Success(response)
        } catch (ex: Exception) {
            Result.Error(ApiErrorBody())
        }
    }
}
