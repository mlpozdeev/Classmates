package com.mlpozdeev.classmatesapp.dagger

import com.mlpozdeev.classmatesapp.presentation.fragments.students.view.StudentsFragment
import dagger.Subcomponent

@FragmentScope
@Subcomponent(modules = [ScreenModule::class])
interface ScreenComponent {

    @Subcomponent.Builder
    interface Builder {
        fun screenModule(module: ScreenModule): Builder
        fun build(): ScreenComponent
    }

    fun inject(studentsFragment: StudentsFragment)
}