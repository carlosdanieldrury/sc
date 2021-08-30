package com.drury.suggesticchallenge

import android.app.Application
import com.drury.suggesticchallenge.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class AgendaApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    // This will create the koin instance that allows us to use Dependency Injection
    private fun initKoin() {
        startKoin{
            androidLogger()
            androidContext(this@AgendaApplication)
            modules(appModule)
        }
    }
}