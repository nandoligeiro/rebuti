package com.nandoligeiro.ituber.presentation.coroutine

import com.nandoligeiro.ituber.domain.abstration.usecase.UseCaseExecutor
import kotlinx.coroutines.CoroutineScope

typealias UseCaseExecutorProvider =
        @JvmSuppressWildcards (coroutineScope: CoroutineScope) -> UseCaseExecutor
