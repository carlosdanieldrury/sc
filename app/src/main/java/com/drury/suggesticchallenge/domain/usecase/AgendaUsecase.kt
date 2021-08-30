package com.drury.suggesticchallenge.domain.usecase

import com.drury.suggesticchallenge.domain.DayMessageModel

interface AgendaUsecase {
    suspend fun getDiaryMessageList(): List<DayMessageModel>
}