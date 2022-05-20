package com.asad.coffeeitapp.core.di.module

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.asad.coffeeitapp.core.db.CoffeeItDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn

@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [DatabaseModule::class]
)
object TestDatabaseModule {
    @Provides
    fun provideCoffeeItDatabase(): CoffeeItDatabase {
        val context = ApplicationProvider.getApplicationContext<Context>()

        return Room.inMemoryDatabaseBuilder(context, CoffeeItDatabase::class.java)
            .allowMainThreadQueries()
            .build()
    }
}
