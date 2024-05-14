package com.nandoligeiro.ituber.domain.abstration.coroutine

import kotlin.coroutines.CoroutineContext

interface CoroutineContextProvider {
    val main: CoroutineContext
    val io: CoroutineContext
}
