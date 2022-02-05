package com.innocv.myuserapp.common.base.viewmodel.viewstate

import com.innocv.myuserapp.common.base.viewmanager.BaseViewManager

interface BaseViewState {
    fun setUp(baseViewManager: BaseViewManager) :Boolean
}