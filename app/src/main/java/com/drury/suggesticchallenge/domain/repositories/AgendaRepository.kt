package com.drury.suggesticchallenge.domain.repositories

import com.drury.suggesticchallenge.domain.DayMessageModel

interface AgendaRepository {
    suspend fun getAllDiaryMessages() : List<DayMessageModel>
}