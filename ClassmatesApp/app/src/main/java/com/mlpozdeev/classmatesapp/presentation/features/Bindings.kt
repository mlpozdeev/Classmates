package com.mlpozdeev.classmatesapp.presentation.features

import androidx.lifecycle.LifecycleOwner
import com.badoo.binder.Binder
import com.badoo.mvicore.android.lifecycle.CreateDestroyBinderLifecycle

abstract class Bindings<T : Any>(
    lifecycleOwner: LifecycleOwner
) {
    protected val binder = Binder(
        lifecycle = CreateDestroyBinderLifecycle(lifecycleOwner.lifecycle)
    )

    abstract fun setup(view: T)
}