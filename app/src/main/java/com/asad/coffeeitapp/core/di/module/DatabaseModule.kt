package com.asad.coffeeitapp.core.di.module

import android.content.Context
import androidx.room.Room
import com.asad.coffeeitapp.core.db.CoffeeItDatabase
import com.asad.coffeeitapp.core.di.Util
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    fun provideCoffeeItDatabase(
        @ApplicationContext context: Context,
    ): CoffeeItDatabase =
        Room
            .databaseBuilder(context, CoffeeItDatabase::class.java, Util.DATA_BASE_NAME)
            .build()
}
