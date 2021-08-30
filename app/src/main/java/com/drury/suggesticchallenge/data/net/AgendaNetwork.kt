package com.drury.suggesticchallenge.data.net

import com.drury.suggesticchallenge.data.repositories.DayMessageEntity

interface AgendaNetwork {
    suspend fun getAgenda() : Result<List<DayMessageEntity>>
}