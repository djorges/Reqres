package com.example.reqres.presentation.viewmodel

import androidx.lifecycle.*
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.reqres.data.entities.UserModel
import com.example.reqres.domain.usecases.GetUsersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getUsersUseCase: GetUsersUseCase,
) : ViewModel() {

    fun listUsers(): Flow<PagingData<UserModel>> {
        return getUsersUseCase().cachedIn(viewModelScope)
    }
}