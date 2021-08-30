package com.drury.suggesticchallenge.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.drury.suggesticchallenge.domain.DayMessageModel
import com.drury.suggesticchallenge.domain.usecase.AgendaUsecase
import com.drury.suggesticchallenge.presentation.view.BaseViewModel
import kotlinx.coroutines.launch


/**
 * ListViewModel: This viewModel is responsible for adapt the content from the business logic to the view.
 */
class ListViewModel(
    private val agendaUsecase: AgendaUsecase
) : BaseViewModel() {

    val pageStatusLiveData = MutableLiveData<ListPageStatus>()

    val listLiveData = MutableLiveData<List<DayMessageModel>>(emptyList())

    fun getDiaryMessageList() {
        viewModelScope.launch {
            pageStatusLiveData.postValue(ListPageStatus.Loading)
            val list = agendaUsecase.getDiaryMessageList()
            if (list.isNullOrEmpty()) {
                pageStatusLiveData.postValue(ListPageStatus.Error)
            } else {
                listLiveData.postValue(list)
                pageStatusLiveData.postValue(ListPageStatus.Content)
            }
        }
    }
}

enum class ListPageStatus {
    Content,
    Loading,
    Error
}
