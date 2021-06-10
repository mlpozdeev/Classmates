package com.mlpozdeev.classmatesapp

import android.app.Application
import com.mlpozdeev.classmatesapp.dagger.ApplicationComponent
import com.mlpozdeev.classmatesapp.dagger.ContextModule
import com.mlpozdeev.classmatesapp.dagger.DaggerApplicationComponent

class ClassMatesApp : Application() {

    lateinit var appComponent: ApplicationComponent
        private set

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerApplicationComponent
            .builder()
            .contextModule(ContextModule(applicationContext))
            .build()
    }
}