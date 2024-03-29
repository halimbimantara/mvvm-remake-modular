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
package com.mindorks.framework.mvvm.ui.feed

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.mindorks.framework.mvvm.ui.feed.blogs.BlogFragment
import com.mindorks.framework.mvvm.ui.feed.opensource.OpenSourceFragment

/**
 * Created by amitshekhar on 10/07/17.
 */
class FeedPagerAdapter(fragmentManager: FragmentManager?) : FragmentStatePagerAdapter(
    fragmentManager!!
) {
    private var mTabCount = 0
    override fun getCount(): Int {
        return mTabCount
    }

    fun setCount(count: Int) {
        mTabCount = count
    }

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> BlogFragment.newInstance()
            1 -> OpenSourceFragment.newInstance()
            else -> BlogFragment.newInstance()
        }
    }
}