package com.innocv.myuserapp.common.base.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.innocv.myuserapp.common.base.viewmanager.BaseViewManager

abstract class BaseActivity : AppCompatActivity(), BaseViewManager {

    protected abstract fun inject()

    protected abstract fun afterInject()

    protected abstract fun configureUI()

    protected abstract fun render()

    protected abstract fun setListeners()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        inject()
        afterInject()
        configureUI()
        setListeners()
        render()
    }

}