package com.asad.coffeeitapp.di

import com.asad.coffeeitapp.data.dataSource.local.CoffeeMachineLocalDataSource
import com.asad.coffeeitapp.data.dataSource.local.CoffeeMachineLocalDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class CoffeeMachineBinderModule {

    @Binds
    abstract fun bindCoffeeMachineLocalDS(coffeeMachineLocalDataSource: CoffeeMachineLocalDataSourceImpl): CoffeeMachineLocalDataSource

//    @Binds
//    abstract fun bindCoffeeMachineRemoteDS(coffeemachine)
}
