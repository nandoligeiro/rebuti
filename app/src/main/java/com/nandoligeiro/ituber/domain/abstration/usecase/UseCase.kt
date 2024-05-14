package com.nandoligeiro.ituber.domain.abstration.usecase

interface UseCase<REQUEST, RESULT> {
    suspend fun execute(input: REQUEST, onResult: (RESULT) -> Unit)
}
