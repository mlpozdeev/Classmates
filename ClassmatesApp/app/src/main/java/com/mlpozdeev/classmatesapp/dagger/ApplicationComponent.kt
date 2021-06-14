package com.mlpozdeev.classmatesapp.dagger

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [DatabaseModule::class, ContextModule::class, SubcomponentsModule::class])
interface ApplicationComponent {
    fun screenComponent(): ScreenComponent.Builder
}