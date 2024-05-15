package com.nandoligeiro.ituber.presentation.coroutine

import com.nandoligeiro.ituber.domain.abstration.coroutine.CoroutineContextProvider
import kotlinx.coroutines.Dispatchers

class AppCoroutineContextProvider : CoroutineContextProvider {
    override val main = Dispatchers.Main
    override val io = Dispatchers.IO
}
