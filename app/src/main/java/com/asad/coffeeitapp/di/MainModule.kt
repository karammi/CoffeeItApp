package com.asad.coffeeitapp.di

import com.asad.coffeeitapp.core.db.CoffeeItDatabase
import com.asad.coffeeitapp.data.dataSource.local.dao.*
import com.asad.coffeeitapp.data.dataSource.remote.CoffeeMachineAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MainModule {

    @Provides
    @Singleton
    fun provideCoffeeMachineAPI(retrofit: Retrofit): CoffeeMachineAPI =
        retrofit.create(CoffeeMachineAPI::class.java)

    @Provides
    @Singleton
    fun provideCoffeeMachineDao(coffeeItDatabase: CoffeeItDatabase): CoffeeMachineDao {
        return coffeeItDatabase.provideCoffeeItDao()
    }

    @Provides
    @Singleton
    fun provideTypeDao(coffeeItDatabase: CoffeeItDatabase): TypeDao {
        return coffeeItDatabase.provideTypeDao()
    }

    @Provides
    @Singleton
    fun provideSizeDao(coffeeItDatabase: CoffeeItDatabase): SizeDao {
        return coffeeItDatabase.provideSizeDao()
    }

    @Provides
    @Singleton
    fun provideExtraDao(coffeeItDatabase: CoffeeItDatabase): ExtraDao {
        return coffeeItDatabase.provideExtraDao()
    }

    @Provides
    @Singleton
    fun provideSubSelectionDao(coffeeItDatabase: CoffeeItDatabase): SubSelectionDao {
        return coffeeItDatabase.provideSubSelectionDao()
    }
}
