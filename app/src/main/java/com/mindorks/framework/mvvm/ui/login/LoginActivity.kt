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

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.mindorks.framework.mvvm.BR
import com.mindorks.framework.mvvm.R
import com.mindorks.framework.mvvm.databinding.ActivityLoginBinding
import com.mindorks.framework.mvvm.di.component.ActivityComponent
import com.mindorks.framework.mvvm.ui.base.BaseActivity
import com.mindorks.framework.mvvm.ui.main.MainActivity

/**
 * Created by amitshekhar on 08/07/17.
 */
class LoginActivity : BaseActivity<ActivityLoginBinding?, LoginViewModel?>(), LoginNavigator {
    private var mActivityLoginBinding: ActivityLoginBinding? = null


    override fun handleError(throwable: Throwable?) {
        // handle error
    }

    override fun login() {
        val email = mActivityLoginBinding!!.etEmail.text.toString()
        val password = mActivityLoginBinding!!.etPassword.text.toString()
        if (mViewModel!!.isEmailAndPasswordValid(email, password)) {
            hideKeyboard()
            mViewModel!!.login(email, password)
        } else {
            Toast.makeText(this, getString(R.string.invalid_email_password), Toast.LENGTH_SHORT)
                .show()
        }
    }

    override fun openMainActivity() {
        val intent: Intent = MainActivity.newIntent(this@LoginActivity)
        startActivity(intent)
        finish()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActivityLoginBinding = viewDataBinding
        mViewModel!!.navigator = this
    }

    override fun performDependencyInjection(buildComponent: ActivityComponent) {
        buildComponent.inject(this)
    }

    companion object {
        @JvmStatic
        fun newIntent(context: Context?): Intent {
            return Intent(context, LoginActivity::class.java)
        }
    }


    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_login
    }
}