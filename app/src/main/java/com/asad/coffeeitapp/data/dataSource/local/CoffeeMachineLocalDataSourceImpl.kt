package com.asad.coffeeitapp.data.dataSource.local

import com.asad.coffeeitapp.core.db.CoffeeItDao
import javax.inject.Inject

class CoffeeMachineLocalDataSourceImpl @Inject constructor(
    private val dao: CoffeeItDao,
) : CoffeeMachineLocalDataSource
