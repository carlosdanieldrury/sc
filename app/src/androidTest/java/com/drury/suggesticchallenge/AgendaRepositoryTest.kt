package com.drury.suggesticchallenge

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.drury.suggesticchallenge.data.net.AgendaNetworkImpl
import com.drury.suggesticchallenge.data.repositories.AgendaRepositoryImpl
import com.drury.suggesticchallenge.data.repositories.DayMessageEntity
import com.drury.suggesticchallenge.domain.repositories.AgendaRepository
import com.drury.suggesticchallenge.utils.fromJson
import com.drury.suggesticchallenge.utils.toDayMessageModel
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
class AgendaRepositoryTest {

    @Test
    fun testRepository() = runBlocking {
        val networkImpl = AgendaNetworkImpl()
        val repository = AgendaRepositoryImpl(networkImpl)
        val list = repository.getAllDiaryMessages()
        val listMock = (Gson().fromJson(json) as? List<DayMessageEntity>)?.map { it.toDayMessageModel() }
        assertEquals(list, listMock)
    }

}