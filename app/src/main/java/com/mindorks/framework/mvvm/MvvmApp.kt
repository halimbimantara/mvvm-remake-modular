package com.mindorks.framework.mvvm

import android.app.Activity
import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.interceptors.HttpLoggingInterceptor
import com.mindorks.framework.mvvm.core.di.ContextModule
import com.mindorks.framework.mvvm.core.di.CoreComponent
import com.mindorks.framework.mvvm.core.di.CoreComponentProvider
import com.mindorks.framework.mvvm.core.di.DaggerCoreComponent
import com.mindorks.framework.mvvm.core.utils.AppLogger
import com.mindorks.framework.mvvm.di.module.AppInjector
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

/**
 * Created by amitshekhar on 07/07/17.
 */
class MvvmApp : Application(), CoreComponentProvider, HasActivityInjector {

    @set:Inject
    internal var activityInjector: DispatchingAndroidInjector<Activity>? = null
    private lateinit var coreComponent: CoreComponent
    override fun onCreate() {
        super.onCreate()
        coreComponent = DaggerCoreComponent.builder().contextModule(ContextModule(this)).build()
        AppInjector.init(this, provideCoreComponent().coreSubcomponent)

        AppLogger.init()
        AndroidNetworking.initialize(applicationContext)
        if (BuildConfig.DEBUG) {
            AndroidNetworking.enableLogging(HttpLoggingInterceptor.Level.BODY)
        }
    }

    override fun activityInjector(): AndroidInjector<Activity>? = activityInjector


    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    override fun provideCoreComponent(): CoreComponent {
        if (!this::coreComponent.isInitialized) {
            coreComponent = DaggerCoreComponent
                .builder().contextModule(ContextModule(this))
                .build()
        }
        return coreComponent
    }

}