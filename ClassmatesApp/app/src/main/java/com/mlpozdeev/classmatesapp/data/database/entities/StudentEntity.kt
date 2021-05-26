package com.mlpozdeev.classmatesapp.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "student")
data class StudentEntity(
    @ColumnInfo(name = "first_name") val firstName: String,
    @ColumnInfo(name = "last_name") val lastName: String,
    @ColumnInfo(name = "patronymic") val patronymic: String?,
    @ColumnInfo(name = "group_name") val groupName: String,
    @PrimaryKey(autoGenerate = true) var id: Int? = null
)