package com.asad.coffeeitapp.core.di.module

import com.asad.coffeeitapp.core.CustomErrorHandler
import com.asad.coffeeitapp.core.ErrorHandler
import dagger.Binds
import dagger.Module
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import javax.inject.Singleton

@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [AppBinderModule::class]
)
abstract class TestAppBinderModule {

    @Binds
    @Singleton
    abstract fun bindErrorHandler(customErrorHandler: CustomErrorHandler): ErrorHandler

    @Binds
    abstract fun bindDispatcherProvider(defaultDispatcher: DefaultDispatcher): DispatcherProvider
}
