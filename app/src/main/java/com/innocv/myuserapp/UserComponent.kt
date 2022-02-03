package com.innocv.myuserapp

import android.content.Context
import com.innocv.myuserapp.feature.main.di.MainComponent
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Component
@Singleton
interface UserComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun context(context: Context): Builder
        fun build(): UserComponent
    }

    fun inject(userApplication: UserApplication)

    //Subcomponents
    fun getMainComponent(): MainComponent
}