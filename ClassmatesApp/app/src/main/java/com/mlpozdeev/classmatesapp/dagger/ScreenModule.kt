package com.mlpozdeev.classmatesapp.dagger

import androidx.lifecycle.LifecycleOwner
import dagger.Module
import dagger.Provides

@Module
class ScreenModule(private val lifecycleOwner: LifecycleOwner) {

    @FragmentScope
    @Provides
    fun provideLifecycleOwner() = lifecycleOwner
}