package com.mindorks.framework.mvvm.di.module

import androidx.core.util.Supplier
import androidx.lifecycle.ViewModelProvider
import com.mindorks.framework.mvvm.ViewModelProviderFactory
import com.mindorks.framework.mvvm.core.data.DataManager
import com.mindorks.framework.mvvm.core.utils.rx.SchedulerProvider
import com.mindorks.framework.mvvm.ui.base.BaseActivity
import com.mindorks.framework.mvvm.ui.feed.FeedPagerAdapter
import com.mindorks.framework.mvvm.ui.feed.FeedViewModel
import com.mindorks.framework.mvvm.ui.login.LoginViewModel
import com.mindorks.framework.mvvm.ui.main.MainViewModel
import com.mindorks.framework.mvvm.ui.splash.SplashViewModel
import dagger.Module
import dagger.Provides


/*
 * Author: rotbolt
 */

@Module
class ActivityModule(private val activity: BaseActivity<*, *>?) {

    @Provides
    fun provideFeedPagerAdapter(): FeedPagerAdapter {
        return FeedPagerAdapter(activity?.supportFragmentManager)
    }

    @Provides
    fun provideFeedViewModel(
        dataManager: DataManager,
        schedulerProvider: SchedulerProvider
    ): FeedViewModel {
        val supplier = Supplier { FeedViewModel(dataManager, schedulerProvider) }
        val factory = ViewModelProviderFactory(
            FeedViewModel::class.java, supplier
        )
        return ViewModelProvider(activity!!, factory).get(FeedViewModel::class.java)
    }

    @Provides
    fun provideMainViewModel(
        dataManager: DataManager,
        schedulerProvider: SchedulerProvider
    ): MainViewModel {
        val supplier = Supplier { MainViewModel(dataManager, schedulerProvider) }
        val factory = ViewModelProviderFactory(
            MainViewModel::class.java, supplier
        )
        return ViewModelProvider(activity!!, factory).get(MainViewModel::class.java)
    }

    @Provides
    fun provideLoginViewModel(
        dataManager: DataManager,
        schedulerProvider: SchedulerProvider
    ): LoginViewModel {
        val supplier = Supplier { LoginViewModel(dataManager, schedulerProvider) }
        val factory = ViewModelProviderFactory(
            LoginViewModel::class.java, supplier
        )
        return ViewModelProvider(activity!!, factory).get(LoginViewModel::class.java)
    }

    @Provides
    fun provideSplashViewModel(
        dataManager: DataManager,
        schedulerProvider: SchedulerProvider
    ): SplashViewModel {
        val supplier = Supplier { SplashViewModel(dataManager, schedulerProvider) }
        val factory = ViewModelProviderFactory(
            SplashViewModel::class.java, supplier
        )
        return ViewModelProvider(activity!!, factory).get(SplashViewModel::class.java)
    }
}