package com.mlpozdeev.classmatesapp.presentation.fragments.students.viewmodel

import com.mlpozdeev.classmatesapp.presentation.features.students.StudentsFeature

object StudentsViewModelTransformer : (StudentsFeature.State) -> StudentsViewModel {
    override fun invoke(state: StudentsFeature.State): StudentsViewModel =
        StudentsViewModel(
            students = state.students
        )
}