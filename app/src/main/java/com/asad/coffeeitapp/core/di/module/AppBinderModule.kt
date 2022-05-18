package com.asad.coffeeitapp.core.di.module

import com.asad.coffeeitapp.core.CustomErrorHandler
import com.asad.coffeeitapp.core.ErrorHandler
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppBinderModule {

    @Binds
    @Singleton
    abstract fun bindErrorHandler(customErrorHandler: CustomErrorHandler): ErrorHandler

    @Binds
    abstract fun bindDispatcherProvider(defaultDispatcher: DefaultDispatcher): DispatcherProvider
}
