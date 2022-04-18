package com.mindorks.framework.mvvm.di.module

import androidx.core.util.Supplier
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.mindorks.framework.mvvm.ViewModelProviderFactory
import com.mindorks.framework.mvvm.core.data.DataManager
import com.mindorks.framework.mvvm.core.utils.rx.SchedulerProvider
import com.mindorks.framework.mvvm.ui.about.AboutViewModel
import com.mindorks.framework.mvvm.ui.base.BaseFragment
import com.mindorks.framework.mvvm.ui.feed.blogs.BlogAdapter
import com.mindorks.framework.mvvm.ui.feed.blogs.BlogViewModel
import com.mindorks.framework.mvvm.ui.feed.opensource.OpenSourceAdapter
import com.mindorks.framework.mvvm.ui.feed.opensource.OpenSourceViewModel
import dagger.Module
import dagger.Provides


/*
 * Author: rotbolt
 */
@Module
class FragmentModule(private val fragment: BaseFragment<*, *>) {

    @Provides
    fun provideLinearLayoutManager(): LinearLayoutManager {
        return LinearLayoutManager(fragment.activity)
    }

    @Provides
    fun provideAboutViewModel(
        dataManager: DataManager,
        schedulerProvider: SchedulerProvider
    ): AboutViewModel {
        val supplier = Supplier { AboutViewModel(dataManager, schedulerProvider) }
        val factory = ViewModelProviderFactory(
            AboutViewModel::class.java, supplier
        )
        return ViewModelProvider(fragment, factory).get(AboutViewModel::class.java)
    }

    @Provides
    fun provideBlogAdapter(): BlogAdapter {
        return BlogAdapter(ArrayList())
    }

    @Provides
    fun provideBlogViewModel(
        dataManager: DataManager,
        schedulerProvider: SchedulerProvider
    ): BlogViewModel {
        val supplier = Supplier { BlogViewModel(dataManager, schedulerProvider) }
        val factory = ViewModelProviderFactory(
            BlogViewModel::class.java, supplier
        )
        return ViewModelProvider(fragment, factory).get(BlogViewModel::class.java)
    }

    @Provides
    fun provideOpenSourceAdapter(): OpenSourceAdapter {
        return OpenSourceAdapter()
    }

    @Provides
    fun provideOpenSourceViewModel(
        dataManager: DataManager,
        schedulerProvider: SchedulerProvider
    ): OpenSourceViewModel {
        val supplier = Supplier { OpenSourceViewModel(dataManager, schedulerProvider) }
        val factory = ViewModelProviderFactory(
            OpenSourceViewModel::class.java, supplier
        )
        return ViewModelProvider(fragment, factory).get(OpenSourceViewModel::class.java)
    }
}