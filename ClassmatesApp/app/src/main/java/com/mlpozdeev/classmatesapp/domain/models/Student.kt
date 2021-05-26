package com.mlpozdeev.classmatesapp.domain.models

data class Student(
    val firstName: String,
    val lastName: String,
    val patronymic: String?,
    val groupName: String,
    var id: Int? = null
)
