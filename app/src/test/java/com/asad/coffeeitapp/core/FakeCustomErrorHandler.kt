package com.asad.coffeeitapp.core

class FakeCustomErrorHandler : ErrorHandler {
    override fun convertToApiErrorBody(e: Exception): ApiErrorBody {
        return ApiErrorBody()
    }
}
