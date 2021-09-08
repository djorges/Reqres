package com.example.reqres.data.entities

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Page<T>(
    val page: Int,
    @SerializedName("per_page")
    val perPage: Int,
    val total: Int,
    @SerializedName("total_pages")
    val totalPages: Int,
    val data: List<T>
)

data class UserModel(
    val id: Int,
    val email: String,
    @SerializedName("first_name")
    val firstName: String,
    @SerializedName("last_name")
    val lastName: String,
    val avatar: String
):Serializable

data class Resource(
    val id: Int,
    val name: String,
    val year: Int,
    val color: String,
    @SerializedName("pantone_value")
    val tone: String
)
