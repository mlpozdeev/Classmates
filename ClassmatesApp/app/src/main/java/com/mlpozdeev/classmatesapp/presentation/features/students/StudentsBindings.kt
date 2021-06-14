package com.mlpozdeev.classmatesapp.presentation.features.students

import androidx.lifecycle.LifecycleOwner
import com.badoo.binder.using
import com.mlpozdeev.classmatesapp.dagger.FragmentScope
import com.mlpozdeev.classmatesapp.presentation.features.Bindings
import com.mlpozdeev.classmatesapp.presentation.fragments.students.view.StudentsFragment
import com.mlpozdeev.classmatesapp.presentation.fragments.students.event.StudentsUiEventTransformer
import com.mlpozdeev.classmatesapp.presentation.fragments.students.viewmodel.StudentsViewModelTransformer
import javax.inject.Inject

@FragmentScope
class StudentsBindings @Inject constructor(
    lifecycleOwner: LifecycleOwner,
    private val feature: StudentsFeature
) : Bindings<StudentsFragment>(lifecycleOwner) {

    override fun setup(view: StudentsFragment) {
        binder.bind(feature to view using StudentsViewModelTransformer)
        binder.bind(view to feature using StudentsUiEventTransformer)
    }
}