package com.asad.coffeeitapp.core.util

import androidx.test.platform.app.InstrumentationRegistry
import okio.buffer
import okio.source
import java.io.InputStreamReader
import java.nio.charset.StandardCharsets

object FileReader {
    fun readStringFromFile(fileName: String): String {
        try {
            val inputStream =
                (
                    InstrumentationRegistry.getInstrumentation().targetContext.applicationContext
                    ).assets.open(
                    fileName
                )

            val builder = StringBuilder()
            val reader = InputStreamReader(inputStream, "UTF-8")

            reader.readLines().forEach {
                builder.append(it)
            }
            return builder.toString()
        } catch (ex: Exception) {
            throw ex
        }
    }

    fun readString(fileName: String): String {
        val inputStream =
            javaClass.classLoader?.getResourceAsStream("api-response/$fileName")
        try {
            val source = inputStream?.let { inputStream.source().buffer() }
            return source!!.readString(StandardCharsets.UTF_8)
        } catch (ex: Exception) {
            throw ex
        }
    }
}
