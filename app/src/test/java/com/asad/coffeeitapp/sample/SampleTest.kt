package com.asad.coffeeitapp.sample

import com.google.common.truth.Truth.assertThat
import okhttp3.HttpUrl
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Test

class SampleTest {

    private val server = MockWebServer()

    @Before
    fun setup() {
        server.start(8080)
        val httpUrl: HttpUrl = server.url("/coffee-machine/60ba1ab72e35f2d9c786c610")
        println("##################################")
        println(httpUrl)
    }

    @After
    fun teardown() {
        server.shutdown()
    }

    @Test
    fun sampleTest() {
        server.enqueue(MockResponse().setBody("Hello guys!"))
        server.enqueue(MockResponse().setBody("How are you guys!"))
        server.enqueue(MockResponse().setBody("Have a great day guys!"))
        assertThat("x").isEqualTo("x")
    }
}
