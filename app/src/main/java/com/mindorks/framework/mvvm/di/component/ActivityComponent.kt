package com.mindorks.framework.mvvm.di.component

import com.mindorks.framework.mvvm.core.data.DataManager
import com.mindorks.framework.mvvm.core.di.CoreSubComponent
import com.mindorks.framework.mvvm.core.utils.rx.SchedulerProvider
import com.mindorks.framework.mvvm.di.module.ActivityModule
import com.mindorks.framework.mvvm.di.scope.ActivityScope
import com.mindorks.framework.mvvm.ui.feed.FeedActivity
import com.mindorks.framework.mvvm.ui.login.LoginActivity
import com.mindorks.framework.mvvm.ui.main.MainActivity
import com.mindorks.framework.mvvm.ui.splash.SplashActivity
import dagger.Component


/*
 * Author: rotbolt
 */
@ActivityScope
@Component(
    dependencies = [CoreSubComponent::class],
    modules = [ActivityModule::class]
)
interface ActivityComponent {
    val dataManager: DataManager
    val schedulerProvider: SchedulerProvider
    fun inject(activity: FeedActivity?)
    fun inject(activity: LoginActivity?)
    fun inject(activity: MainActivity?)
    fun inject(splashActivity: SplashActivity?)
}