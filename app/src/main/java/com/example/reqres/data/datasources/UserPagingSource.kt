package com.example.reqres.data.datasources

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.reqres.data.api.ReqresService
import com.example.reqres.data.entities.UserModel
import javax.inject.Inject

class UserPagingSource @Inject constructor(
    private val service: ReqresService
) : PagingSource<Int, UserModel>() {
    override fun getRefreshKey(state: PagingState<Int, UserModel>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                    ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, UserModel> {
        val pageIndex = params.key ?: STARTING_PAGE_INDEX
        return try {
            val page = service.getListUsers(page = pageIndex)
            val nextPage = pageIndex + 1

            LoadResult.Page(
                    data = page.data,
                    prevKey = null,
                    nextKey = nextPage
            )
        }catch (exception:Exception){
            LoadResult.Error(exception)
        }
    }

    companion object {
        private const val STARTING_PAGE_INDEX = 1
    }
}