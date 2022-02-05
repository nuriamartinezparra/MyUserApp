package com.innocv.myuserapp.common.base.viewmodel.livedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class BaseLiveData<T>: LiveData<T>(){

    private val mutableLiveData by lazy {
        MutableLiveData<T>()
    }
    
    var liveData: LiveData<T> = mutableLiveData

    fun getMutableObserver() = mutableLiveData

}