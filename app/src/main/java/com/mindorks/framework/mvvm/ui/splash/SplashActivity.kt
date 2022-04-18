/*
 *  Copyright (C) 2017 MINDORKS NEXTGEN PRIVATE LIMITED
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      https://mindorks.com/license/apache-v2
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License
 */
package com.mindorks.framework.mvvm.ui.splash

import android.content.Intent
import android.os.Bundle
import com.mindorks.framework.mvvm.BR
import com.mindorks.framework.mvvm.R
import com.mindorks.framework.mvvm.databinding.ActivitySplashBinding
import com.mindorks.framework.mvvm.di.component.ActivityComponent
import com.mindorks.framework.mvvm.ui.base.BaseActivity
import com.mindorks.framework.mvvm.ui.feed.FeedActivity
import com.mindorks.framework.mvvm.ui.feedbuilder.FeedActivityV2
import com.mindorks.framework.mvvm.ui.login.LoginActivity

/**
 * Created by amitshekhar on 08/07/17.
 */
class SplashActivity : BaseActivity<ActivitySplashBinding, SplashViewModel>(), SplashNavigator {

    override fun openLoginActivity() {
        val intent: Intent = LoginActivity.newIntent(this@SplashActivity)
        startActivity(intent)
        finish()
    }

    override fun openMainActivity() {
        val intent: Intent = FeedActivity.newIntent(this@SplashActivity)
        startActivity(intent)
        finish()
    }

     fun openMainActivity2() {
        val intent: Intent = FeedActivityV2.newIntent(this@SplashActivity)
        startActivity(intent)
        finish()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewModel!!.navigator = this
//        mViewModel!!.startSeeding()
        openMainActivity2()
    }

    override fun performDependencyInjection(buildComponent: ActivityComponent) {
        buildComponent.inject(this)
    }

    override fun getBindingVariable(): Int {
       return BR.viewModel
    }

    override fun getLayoutId(): Int {
      return R.layout.activity_splash
    }
}