package com.mlpozdeev.classmatesapp.domain.interactors

import com.mlpozdeev.classmatesapp.data.repositories.StudentsRepository
import com.mlpozdeev.classmatesapp.domain.models.Student
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class StudentsInteractor @Inject constructor(private val repository: StudentsRepository) {

    val students: Single<List<Student>> = repository.students
}