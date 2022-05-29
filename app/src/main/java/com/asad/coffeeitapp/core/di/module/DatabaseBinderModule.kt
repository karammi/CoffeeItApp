package com.asad.coffeeitapp.core.di.module

import com.asad.coffeeitapp.core.db.CoffeeItDatabase
import com.asad.coffeeitapp.data.dataSource.local.dao.SizeDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

//@Module
//@InstallIn(SingletonComponent::class)
//object DatabaseBinderModule {
//
//    @Provides
//    fun provideSizeDao(database: CoffeeItDatabase): SizeDao {
//        return database.provideSizeDao()
//    }
//
//}