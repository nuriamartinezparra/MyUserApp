package com.innocv.myuserapp.common.base.activity

import android.content.Context
import com.innocv.myuserapp.common.base.fragment.BaseFragment
import com.innocv.myuserapp.common.base.viewmanager.BaseViewManager

abstract class BaseActivityFragmentScreen: BaseActivity(), BaseViewManager {

    protected lateinit var currentFragment: BaseFragment

    override fun getLayoutContext(): Context {
        return this
    }

    abstract fun next()

    abstract fun previous()
}