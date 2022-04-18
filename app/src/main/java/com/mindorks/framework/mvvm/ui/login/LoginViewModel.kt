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
package com.mindorks.framework.mvvm.ui.login

import android.text.TextUtils
import com.mindorks.framework.mvvm.core.data.DataManager
import com.mindorks.framework.mvvm.ui.base.BaseViewModel
import com.mindorks.framework.mvvm.core.utils.CommonUtils
import com.mindorks.framework.mvvm.core.utils.rx.SchedulerProvider

/**
 * Created by amitshekhar on 08/07/17.
 */
class LoginViewModel(dataManager: DataManager, schedulerProvider: SchedulerProvider) :
    BaseViewModel<LoginNavigator?>(dataManager, schedulerProvider) {
    fun isEmailAndPasswordValid(email: String?, password: String?): Boolean {
        // validate email and password
        if (TextUtils.isEmpty(email)) {
            return false
        }
        if (!CommonUtils.isEmailValid(email)) {
            return false
        }
        return !TextUtils.isEmpty(password)
    }

    fun login(email: String?, password: String?) {
        setIsLoading(true)
    }

    fun onFbLoginClick() {
        setIsLoading(true)
    }

    fun onGoogleLoginClick() {
        setIsLoading(true)
    }

    fun onServerLoginClick() {
        navigator?.login()
    }
}