package com.innocv.myuserapp

import android.app.Activity
import android.app.Application
import android.content.Context
import com.innocv.myuserapp.DaggerUserComponent.builder

class UserApplication : Application(){

    private lateinit var userComponent: UserComponent

    override fun onCreate() {
        super.onCreate()
        setup()
    }

    private fun setup(){
        userComponent = builder().context(applicationContext).build()
        userComponent.inject(this)
    }

    fun getApplicationComponent(): UserComponent {
        return userComponent
    }

    companion object {

        fun get(activity: Activity): UserApplication {
            return activity.application as UserApplication
        }

        fun get(context: Context): UserApplication {
            return context.applicationContext as UserApplication
        }
    }
}