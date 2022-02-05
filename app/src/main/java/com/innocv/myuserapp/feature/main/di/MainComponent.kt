package com.innocv.myuserapp.feature.main.di

import com.innocv.myuserapp.feature.main.view.MainActivity
import com.innocv.myuserapp.feature.main.view.fragment.ListUserFragment
import dagger.Subcomponent

@Subcomponent(modules = [MainModule::class])
interface MainComponent {
    fun inject(mainActivity: MainActivity)

    fun inject(listUserFragment: ListUserFragment)

}