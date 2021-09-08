package com.example.reqres.domain.repositories

import androidx.paging.PagingData
import com.example.reqres.data.entities.*
import kotlinx.coroutines.flow.Flow

interface MainRepository {
    fun listUsers(): Flow<PagingData<UserModel>>
}