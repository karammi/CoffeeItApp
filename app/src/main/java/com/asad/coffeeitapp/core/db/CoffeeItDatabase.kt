package com.asad.coffeeitapp.core.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.asad.coffeeitapp.data.dataSource.local.entity.*

@Database(
    entities = [
        CoffeeMachineEntity::class,
        TypeEntity::class,
        SizeEntity::class,
        ExtraEntity::class,
        SubSelectionEntity::class
    ],
    version = 2
)
abstract class CoffeeItDatabase : RoomDatabase() {
//    abstract fun provideCoffeeItDao(): CoffeeMachineDao
//
//    abstract fun provideTypeDao(): TypeDao
//
//    abstract fun provideSizeDao(): SizeDao
//
//    abstract fun provideExtraDao(): ExtraDao
//
//    abstract fun provideSubSelectionDao(): SubSelectionDao
}
