package com.asad.coffeeitapp.core.di.module

import dagger.Module
import dagger.hilt.android.testing.UninstallModules

@Module
@UninstallModules(NetworkModule::class)
class NetworkModuleTest
