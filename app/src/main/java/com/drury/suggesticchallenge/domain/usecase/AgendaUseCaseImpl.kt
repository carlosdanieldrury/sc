package com.drury.suggesticchallenge.domain.usecase

import com.drury.suggesticchallenge.domain.DayMessageModel
import com.drury.suggesticchallenge.domain.repositories.AgendaRepository

class AgendaUseCaseImpl(
    private val agendaRepository: AgendaRepository
) : AgendaUsecase {

    override suspend fun getDiaryMessageList(): List<DayMessageModel> {
        return agendaRepository.getAllDiaryMessages()
    }
}