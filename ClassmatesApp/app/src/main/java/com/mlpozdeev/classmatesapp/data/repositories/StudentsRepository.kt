package com.mlpozdeev.classmatesapp.data.repositories

import com.mlpozdeev.classmatesapp.data.database.AppDatabase
import javax.inject.Inject

class StudentsRepository @Inject constructor(
    private val db: AppDatabase
) {
}