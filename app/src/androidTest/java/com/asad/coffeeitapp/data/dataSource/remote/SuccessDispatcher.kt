package com.asad.coffeeitapp.data.dataSource.remote

import com.asad.coffeeitapp.core.util.FileReader
import okhttp3.mockwebserver.Dispatcher
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.RecordedRequest

class SuccessDispatcher : Dispatcher() {
    override fun dispatch(request: RecordedRequest): MockResponse {
        return MockResponse().setResponseCode(200)
            .setBody(FileReader.readString("success_response_200.json"))
//        return when (request.path) {
//            "" -> MockResponse().setResponseCode(200).setBody("{}")
//            else -> MockResponse().setResponseCode(404).setBody("{}")
//        }
    }
}
