package com.asad.coffeeitapp.di

import com.asad.coffeeitapp.data.dataSource.local.CoffeeMachineLocalDataSource
import com.asad.coffeeitapp.data.dataSource.local.CoffeeMachineLocalDataSourceImpl
import com.asad.coffeeitapp.data.dataSource.remote.CoffeeMachineRemoteDataSource
import com.asad.coffeeitapp.data.dataSource.remote.CoffeeMachineRemoteDataSourceImpl
import com.asad.coffeeitapp.data.repository.CoffeeMachineRepositoryImpl
import com.asad.coffeeitapp.domain.repository.CoffeeMachineRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.testing.TestInstallIn

//@Module
//@TestInstallIn(
//    components = [ViewModelComponent::class],
//    replaces = [CoffeeMachineBinderModule::class]
//)
//abstract class TestCoffeeMachineBinderModule {
//
//    @Binds
//    abstract fun bindCoffeeMachineLocalDS(coffeeMachineLocalDataSource: CoffeeMachineLocalDataSourceImpl): CoffeeMachineLocalDataSource
//
//    @Binds
//    abstract fun bindCoffeeMachineRemoteDS(coffeeMachineRemoteDataSource: CoffeeMachineRemoteDataSourceImpl): CoffeeMachineRemoteDataSource
//
//    @Binds
//    abstract fun bindCoffeeMachineRepository(coffeeMachineRepository: CoffeeMachineRepositoryImpl): CoffeeMachineRepository
//}
