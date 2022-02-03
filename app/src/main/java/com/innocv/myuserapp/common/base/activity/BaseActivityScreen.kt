package com.innocv.myuserapp.common.base.activity

import android.content.Context
import com.innocv.myuserapp.common.base.viewmanager.BaseViewManager


abstract class BaseActivityScreen : BaseActivity(), BaseViewManager {
    override fun getLayoutContext(): Context {
        return this
    }
}