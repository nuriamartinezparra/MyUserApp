package com.innocv.myuserapp.common.base.viewmodel

import com.innocv.myuserapp.common.base.viewmodel.livedata.BaseLiveData
import com.innocv.myuserapp.common.base.viewmodel.viewstate.BaseViewState

interface BaseViewModelInterface {
    fun getViewModelObserver(): BaseLiveData<BaseViewState>
    fun getComponentObserver(): BaseLiveData<BaseViewState>
}