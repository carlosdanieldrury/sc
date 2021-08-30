package com.drury.suggesticchallenge.di

import com.drury.suggesticchallenge.data.net.AgendaNetwork
import com.drury.suggesticchallenge.data.net.AgendaNetworkImpl
import com.drury.suggesticchallenge.data.repositories.AgendaRepositoryImpl
import com.drury.suggesticchallenge.domain.repositories.AgendaRepository
import com.drury.suggesticchallenge.domain.usecase.AgendaUseCaseImpl
import com.drury.suggesticchallenge.domain.usecase.AgendaUsecase
import com.drury.suggesticchallenge.presentation.viewmodel.ListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    single<AgendaRepository> { AgendaRepositoryImpl(get()) }
    single<AgendaNetwork> { AgendaNetworkImpl() }
    single<AgendaUsecase> { AgendaUseCaseImpl(get()) }

    viewModel { ListViewModel(get()) }
}
