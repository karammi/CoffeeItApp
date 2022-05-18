package com.asad.coffeeitapp.data.repository

import com.asad.coffeeitapp.coffee.COFFEE_MACHINE_FAKE
import com.asad.coffeeitapp.core.data
import com.asad.coffeeitapp.data.dataSource.remote.CoffeeMachineRemoteDataSource
import com.asad.coffeeitapp.data.dataSource.remote.FakeCoffeeMachineRemoteDataSourceImpl
import com.asad.coffeeitapp.domain.repository.CoffeeMachineRepository
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class CoffeeMachineRepositoryImplTest {

    private lateinit var fakeCoffeeMachineRemoteDataSource: CoffeeMachineRemoteDataSource

//    @Mock
//    private lateinit var remote: CoffeeMachineRemoteDataSource

    // system under test
    private lateinit var coffeeMachineRepositoryImpl: CoffeeMachineRepository

    @Before
    fun setup() {
//        remote = mock(CoffeeMachineRemoteDataSourceImpl::class.java)
        fakeCoffeeMachineRemoteDataSource = FakeCoffeeMachineRemoteDataSourceImpl()
        coffeeMachineRepositoryImpl = CoffeeMachineRepositoryImpl(
            fakeCoffeeMachineRemoteDataSource
        )
    }

    @Test
    fun `fetch coffee machine should return Success result`() = runBlocking {
        // arrange
        val expectedValue = COFFEE_MACHINE_FAKE

        // act
        val result = coffeeMachineRepositoryImpl.fetchCoffeeMachineInfo("60ba1ab72e35f2d9c786c610")

        // assert
        assertThat(result.data).isEqualTo(expectedValue)
    }

    @Test
    fun `check coffee machine call remote data source`() = runBlocking {
        val result = coffeeMachineRepositoryImpl.fetchCoffeeMachineInfo("60ba1ab72e35f2d9c786c610")

//        `when`(remote.fetchCoffeeMachineInfo("60ba1ab72e35f2d9c786c610")).thenReturn(
//            Result.Success(
//                data = ACTUAL_VALUE
//            )
//        )
//
//        verify(remote, times(1)).fetchCoffeeMachineInfo("60ba1ab72e35f2d9c786c610")
    }
}
