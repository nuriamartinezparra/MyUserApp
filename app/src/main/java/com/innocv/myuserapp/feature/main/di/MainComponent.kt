package com.innocv.myuserapp.feature.main.di

import com.innocv.myuserapp.feature.main.view.MainActivity
import dagger.Subcomponent

@Subcomponent(modules = [MainModule::class])
interface MainComponent {
    fun inject(mainActivity: MainActivity)
}