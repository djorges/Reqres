package com.example.reqres.data.repositories


import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.reqres.data.datasources.UserPagingSource
import com.example.reqres.data.entities.*
import com.example.reqres.domain.repositories.MainRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(
    private val userPagingSource: UserPagingSource
) : MainRepository {

    override fun listUsers(): Flow<PagingData<UserModel>> {
        return Pager(
            config = PagingConfig(
                pageSize = PAGE_SIZE,
                enablePlaceholders = false,
                maxSize = MAX_PAGES
            ),
            pagingSourceFactory = { userPagingSource }
        ).flow
    }

    companion object {
        private const val PAGE_SIZE = 6
        private const val MAX_PAGES = 50
    }
}