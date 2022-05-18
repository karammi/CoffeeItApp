package com.asad.coffeeitapp.core

import okhttp3.ResponseBody
import retrofit2.Converter
import retrofit2.HttpException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import javax.inject.Inject

class CustomErrorHandler @Inject constructor(
    private val converter: Converter<ResponseBody, ApiErrorBody>,
) : ErrorHandler {

    override fun convertToApiErrorBody(e: Exception): ApiErrorBody {
        return when (e) {
            is HttpException -> {
                var apiErrorBody: ApiErrorBody? = null
                e.response()?.errorBody()?.let {
                    apiErrorBody = converter.convert(it)
                }
                if (apiErrorBody != null) {
                    apiErrorBody!!.copy(message = apiErrorBody!!.message ?: "connectionError")
                } else {
                    ApiErrorBody(message = "ConnectionError")
                }
            }
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
    }
}

interface ErrorHandler {
    fun convertToApiErrorBody(e: Exception): ApiErrorBody
}
