package com.mlpozdeev.classmatesapp.presentation.fragments.students.event

import com.mlpozdeev.classmatesapp.presentation.features.students.StudentsFeature

object StudentsUiEventTransformer : (StudentsUiEvent) -> StudentsFeature.Wish {
    override fun invoke(event: StudentsUiEvent): StudentsFeature.Wish = when(event) {
        StudentsUiEvent.LoadData -> StudentsFeature.Wish.LoadNewData
    }
}