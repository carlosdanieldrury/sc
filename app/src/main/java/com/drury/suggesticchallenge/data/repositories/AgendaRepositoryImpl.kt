package com.drury.suggesticchallenge.data.repositories

import com.drury.suggesticchallenge.data.net.AgendaNetwork
import com.drury.suggesticchallenge.domain.DayMessageModel
import com.drury.suggesticchallenge.domain.repositories.AgendaRepository
import com.drury.suggesticchallenge.utils.toDayMessageModel


/**
 * AgendaRepositoryImpl: This layer is responsible to deliver a model which is used by up layers
 */
class AgendaRepositoryImpl(
    private val agendaNetwork: AgendaNetwork
) : AgendaRepository {

    override suspend fun getAllDiaryMessages() : List<DayMessageModel> {
        val result = agendaNetwork.getAgenda()
        return if (result.isSuccess) {
            result.getOrElse { emptyList() }.map { dayEntity -> dayEntity.toDayMessageModel() }
        } else {
            emptyList()
        }
    }

}