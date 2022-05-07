package com.asad.coffeeitapp.data.dataSource.local

import com.asad.coffeeitapp.core.db.CoffeeItDao
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class CoffeeMachineLocalDataSourceImpl @Inject constructor(
    private val dao: CoffeeItDao,
) : CoffeeMachineLocalDataSource
