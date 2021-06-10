package com.mlpozdeev.classmatesapp.dagger

import com.mlpozdeev.classmatesapp.presentation.features.StudentsFeature
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [DatabaseModule::class, ContextModule::class])
interface ApplicationComponent {
    fun getFeature(): StudentsFeature
}