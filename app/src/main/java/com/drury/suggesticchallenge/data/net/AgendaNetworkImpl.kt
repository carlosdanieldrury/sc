package com.drury.suggesticchallenge.data.net

import com.drury.suggesticchallenge.data.repositories.DayMessageEntity
import com.drury.suggesticchallenge.utils.fromJson
import com.google.gson.Gson
import json
import kotlinx.coroutines.delay
import java.io.File

/**
 * AgendaNetworkImpl: Just a layer which it is simulated a call to an api.
 * In this class we would change the json string to a response from an api using Retrofit/KTor
 * the json String is a val in the data.kt file
 */
class AgendaNetworkImpl : AgendaNetwork {

    override suspend fun getAgenda(): Result<List<DayMessageEntity>> {
        // Just to simulate an api call
        delay(4_000)
        return try {
            // Converts the json format to our entity
            val result = Gson().fromJson(json) as? List<DayMessageEntity>
            if (result != null) {
                Result.success(result)
            } else {
                Result.failure(Exception("Error while getting data"))
            }
        } catch (e : Exception) {
            Result.failure(e)
        }
    }
}