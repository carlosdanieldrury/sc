package com.drury.suggesticchallenge

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.drury.suggesticchallenge.data.net.AgendaNetworkImpl
import com.drury.suggesticchallenge.data.repositories.DayMessageEntity
import com.drury.suggesticchallenge.utils.fromJson
import com.google.gson.Gson
import json
import kotlinx.coroutines.runBlocking

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class AgendaNetworkTest {

    @Test
    fun testListDayMessageEntity() = runBlocking {
        val agendaNetwork = AgendaNetworkImpl()
        val list = agendaNetwork.getAgenda()
        val listFromJson = Result.success(Gson().fromJson(json) as? List<DayMessageEntity>)
        assertEquals(list, listFromJson)
    }

}