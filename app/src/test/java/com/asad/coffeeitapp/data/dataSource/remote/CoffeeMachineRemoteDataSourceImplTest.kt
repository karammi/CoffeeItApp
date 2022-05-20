package com.asad.coffeeitapp.data.dataSource.remote

import com.asad.coffeeitapp.core.ApiErrorBody
import com.asad.coffeeitapp.core.CustomErrorHandler
import com.asad.coffeeitapp.core.Result
import com.asad.coffeeitapp.core.enqueueResponse
import com.asad.coffeeitapp.data.dataSource.remote.model.CoffeeMachineResponseModel
import com.asad.coffeeitapp.data.dataSource.remote.model.ExtraResponseModel
import com.asad.coffeeitapp.data.dataSource.remote.model.SizeResponseModel
import com.asad.coffeeitapp.data.dataSource.remote.model.SubSelectionResponseModel
import com.asad.coffeeitapp.data.dataSource.remote.model.TypeResponseModel
import com.google.common.truth.Truth.assertThat
import com.squareup.moshi.Moshi
import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

class CoffeeMachineRemoteDataSourceImplTest {
    private lateinit var mockWebServer: MockWebServer

    private lateinit var client: OkHttpClient

    private lateinit var retrofit: Retrofit

    private lateinit var api: CoffeeMachineAPI

    private lateinit var converter: Converter<ResponseBody, ApiErrorBody>

    private lateinit var customErrorHandler: CustomErrorHandler

    private lateinit var sut: CoffeeMachineRemoteDataSource

    @Before
    fun setup() {

        mockWebServer = MockWebServer()
//        mockWebServer.url()

        client = OkHttpClient.Builder()
            .connectTimeout(1, TimeUnit.SECONDS)
            .readTimeout(1, TimeUnit.SECONDS)
            .writeTimeout(1, TimeUnit.SECONDS)
            .build()
        retrofit = Retrofit.Builder()
            .baseUrl(mockWebServer.url("/"))
            .client(client)
            .addConverterFactory(MoshiConverterFactory.create(Moshi.Builder().build()))
            .build()

        api = retrofit.create(CoffeeMachineAPI::class.java)

        converter =
            retrofit.responseBodyConverter(ApiErrorBody::class.java, arrayOf())

        customErrorHandler = CustomErrorHandler(converter)

        sut = CoffeeMachineRemoteDataSourceImpl(api, customErrorHandler)
    }

    @After
    fun teardown() {
        mockWebServer.shutdown()
    }

    @Test
    fun `fetch coffee machine info should return success response`() = runBlocking {
        // arrange
        mockWebServer.enqueueResponse("success_response_200.json", code = 200)

        val expected = Result.Success(data = ACTUAL_VALUE)

        // act
        val actual = sut.fetchCoffeeMachineInfo("60ba1ab72e35f2d9c786c610")
        // Request received by the mock server
        val request = mockWebServer.takeRequest()

        // assert
        assertThat(request.path).isEqualTo("/coffee-machine/60ba1ab72e35f2d9c786c610")
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `fetch coffee machine with serverError 500 should return ApiError`() {
        // arrange
        mockWebServer.enqueueResponse("server_error_response_500.json", 500)
        val errorResult = ApiErrorBody(statusCode = "500", message = "Internal server error")
        val expectedValue = Result.Error(errorResult)

        // act
        runBlocking {
            val actual = sut.fetchCoffeeMachineInfo("60ba1ab72e35f2d9c786c61")

            // assert
            assertThat(actual).isEqualTo(expectedValue)
        }
    }

    @Test
    fun `fetch incorrect url should return ApiError 404`() {
        // arrange
        mockWebServer.enqueueResponse("error_response_404.json", 404)
        val errorResult = ApiErrorBody(
            statusCode = "404",
            message = "Cannot GET /coffee-machin/60ba1ab72e35f2d9c786c610",
            error = "Not Found"
        )
        val expectedValue = Result.Error(errorResult)

        runBlocking {
            // act
            val actual = sut.fetchCoffeeMachineInfo("")

            // assert
            assertThat(actual).isEqualTo(expectedValue)
        }
    }
}

val ACTUAL_VALUE = CoffeeMachineResponseModel(
    id = "60ba1ab72e35f2d9c786c610",
    typeResponseModels = listOf(
        TypeResponseModel(
            id = "60ba1a062e35f2d9c786c56d",
            name = "Ristretto",
            sizes = listOf("60ba18d13ca8c43196b5f606", "60ba3368c45ecee5d77a016b"),
            extras = listOf("60ba197c2e35f2d9c786c525")
        ),
        TypeResponseModel(
            id = "60be1db3c45ecee5d77ad890",
            name = "Espresso",
            sizes = listOf("60ba3368c45ecee5d77a016b", "60ba33dbc45ecee5d77a01f8"),
            extras = listOf("60ba34a0c45ecee5d77a0263")
        ),
        TypeResponseModel(
            id = "60be1eabc45ecee5d77ad960",
            name = "Cappuccino",
            sizes = listOf(
                "60ba18d13ca8c43196b5f606",
                "60ba3368c45ecee5d77a016b",
                "60ba33dbc45ecee5d77a01f8"
            ),
            extras = listOf("60ba197c2e35f2d9c786c525", "60ba34a0c45ecee5d77a0263")
        )
    ),
    sizeResponseModels = listOf(
        SizeResponseModel(
            id = "60ba18d13ca8c43196b5f606",
            name = "Large",
            v = 0
        ),
        SizeResponseModel(
            id = "60ba3368c45ecee5d77a016b",
            name = "Venti",
            v = null
        ),
        SizeResponseModel(id = "60ba33dbc45ecee5d77a01f8", name = "Tall", v = null)
    ),
    extraResponseModels = listOf(
        ExtraResponseModel(
            id = "60ba197c2e35f2d9c786c525",
            name = "Select the amount of sugar",
            subSelectionResponseModels = listOf(
                SubSelectionResponseModel(
                    id = "60ba194dfdd5e192e14eaa75",
                    name = "A lot"
                ),
                SubSelectionResponseModel(
                    id = "60ba195407e1dc8a4e33b5e5",
                    name = "Normal"
                )
            )
        ),
        ExtraResponseModel(
            id = "60ba34a0c45ecee5d77a0263",
            name = "Select type of milk",
            subSelectionResponseModels = listOf(
                SubSelectionResponseModel(
                    id = "611a1adeff35e4db9df19667",
                    name = "Soy"
                ),
                SubSelectionResponseModel(
                    id = "60ba348d8c75424ac5ed259e",
                    name = "Oat"
                ),
                SubSelectionResponseModel(
                    id = "60ba349a869d7a04642b41f4",
                    name = "Cow"
                )
            )
        )
    )
)
