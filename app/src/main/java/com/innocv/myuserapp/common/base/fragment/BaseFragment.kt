package com.innocv.myuserapp.common.base.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.innocv.myuserapp.common.base.viewmanager.BaseViewManager

abstract class BaseFragment: Fragment(), BaseViewManager {

    abstract fun configureUI()

    abstract fun render()

    abstract fun setListeners()

    abstract fun inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        inject()
        render()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configureUI()
        setListeners()
    }
}