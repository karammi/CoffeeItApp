package com.asad.coffeeitapp.core.di.module

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.test.StandardTestDispatcher

class TestDispatcher : DispatcherProvider {

    private val coroutineTestDispatcher = StandardTestDispatcher()
    override val io: CoroutineDispatcher
        get() = coroutineTestDispatcher
    override val main: CoroutineDispatcher
        get() = coroutineTestDispatcher
    override val default: CoroutineDispatcher
        get() = coroutineTestDispatcher
}
