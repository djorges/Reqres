package com.example.reqres.data.api

import com.example.reqres.data.entities.*
import okhttp3.ResponseBody
import retrofit2.http.*

interface ReqresService {
    /*Users*/
    @GET("users")
    suspend fun getListUsers(@Query("page") page:Int): Page<UserModel>

    /*Resources*/
    @GET("unknown")
    suspend fun getListResources(): Page<Resource>

    /*Employee*/
    @POST("users")
    suspend fun createEmployee(@Body employee: Employee): EmployeeData

    @PUT("users/{id}")
    suspend fun updateEmployee(@Path("id") id:Int, @Body employee: Employee): ResponseBody

    @DELETE("users/{id}")
    suspend fun deleteEmployee(@Path("id") id:Int): ResponseBody
}