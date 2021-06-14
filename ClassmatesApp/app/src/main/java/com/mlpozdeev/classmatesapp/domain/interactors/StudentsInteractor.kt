package com.mlpozdeev.classmatesapp.domain.interactors

import com.mlpozdeev.classmatesapp.dagger.FragmentScope
import com.mlpozdeev.classmatesapp.data.repositories.StudentsRepository
import com.mlpozdeev.classmatesapp.domain.models.Student
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@FragmentScope
class StudentsInteractor @Inject constructor(repository: StudentsRepository) {

    val students: Single<List<Student>> = repository.students
        .subscribeOn(Schedulers.io())
}