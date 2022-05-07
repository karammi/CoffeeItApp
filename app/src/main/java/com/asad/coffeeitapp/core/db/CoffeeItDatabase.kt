package com.asad.coffeeitapp.core.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [], version = 1)
abstract class CoffeeItDatabase : RoomDatabase() {
    abstract fun provideCoffeeItDao(): CoffeeItDao
}
