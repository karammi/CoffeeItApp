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
// @InstallIn(SingletonComponent::class)
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [DatabaseModule::class]
)
// @UninstallModules(DatabaseModule::class)
object TestDatabaseModule {
    @Provides
    fun provideCoffeeItDatabase(
//        @ApplicationContext context: Context,
    ): CoffeeItDatabase {
        val context = ApplicationProvider.getApplicationContext<Context>()

        return Room.inMemoryDatabaseBuilder(context, CoffeeItDatabase::class.java)
            .allowMainThreadQueries()
            .build()
    }
}
