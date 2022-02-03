package com.innocv.myuserapp.feature.main.di

import com.innocv.myuserapp.feature.main.viewmodel.MainViewModel
import com.innocv.myuserapp.feature.main.viewmodel.MainViewModelInterface
import dagger.Module
import dagger.Provides

@Module
class MainModule {

    @Provides
    fun provideMainViewModel(
    ): MainViewModelInterface = MainViewModel()
}