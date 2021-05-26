package com.mlpozdeev.classmatesapp.domain.interactors

import com.mlpozdeev.classmatesapp.data.repositories.StudentsRepository
import com.mlpozdeev.classmatesapp.domain.models.Student
import javax.inject.Inject

class StudentsInteractor @Inject constructor(private val repository: StudentsRepository) {

    val students = repository.students

    suspend fun insertStudent(student: Student) {
        repository.insertStudent(student)
    }

    suspend fun deleteStudents() {
        repository.deleteStudents()
    }
}