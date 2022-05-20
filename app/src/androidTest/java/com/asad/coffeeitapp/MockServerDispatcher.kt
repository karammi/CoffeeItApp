package com.asad.coffeeitapp

import com.asad.coffeeitapp.core.util.FileReader
import okhttp3.mockwebserver.Dispatcher
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.RecordedRequest

class MockServerDispatcher {

    internal inner class SuccessDispatcher : Dispatcher() {
        override fun dispatch(request: RecordedRequest): MockResponse {
            return when (request.path) {
                "/coffee-machine/" -> MockResponse().setResponseCode(200)
                    .setBody(FileReader.readStringFromFile("success_response_200.json"))
                else -> MockResponse().setResponseCode(404).setBody("{}")
            }
        }
    }

    internal inner class ErrorResponse : Dispatcher() {
        override fun dispatch(request: RecordedRequest): MockResponse {
            return MockResponse().setResponseCode(500)
                .setBody(FileReader.readStringFromFile("server_error_response_500.json"))
        }
    }
}
