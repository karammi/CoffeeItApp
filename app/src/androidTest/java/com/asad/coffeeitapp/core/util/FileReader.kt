package com.asad.coffeeitapp.core.util

import androidx.test.platform.app.InstrumentationRegistry
import java.io.InputStreamReader

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
}
