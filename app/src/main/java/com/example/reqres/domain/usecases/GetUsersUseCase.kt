package com.example.reqres.domain.usecases

import androidx.paging.PagingData
import com.example.reqres.data.entities.UserModel
import com.example.reqres.domain.repositories.MainRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetUsersUseCase @Inject constructor(
    private val repository: MainRepository
){
    operator fun invoke(): Flow<PagingData<UserModel>> {
        return repository.listUsers()
    }
}