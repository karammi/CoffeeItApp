package com.asad.coffeeitapp.core.di.module

import android.content.Context
import androidx.room.Room
import com.asad.coffeeitapp.core.db.CoffeeItDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.testing.UninstallModules

@Module
@UninstallModules(DatabaseModule::class)
class DatabaseModuleTest {
    @Provides
    fun provideCoffeeItDatabase(
        @ApplicationContext context: Context,
    ): CoffeeItDatabase =
        Room.inMemoryDatabaseBuilder(context, CoffeeItDatabase::class.java).build()
}
