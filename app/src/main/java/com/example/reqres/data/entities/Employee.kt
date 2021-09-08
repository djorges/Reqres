package com.example.reqres.data.entities

import java.util.*

open class Employee(
    val name: String,
    val job: String
)
class EmployeeData(
    val id: Int,
    val createdAt: Date,
    name: String,
    job: String
): Employee(name, job)