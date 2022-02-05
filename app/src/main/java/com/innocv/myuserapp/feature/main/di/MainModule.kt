package com.innocv.myuserapp.feature.main.di

import com.innocv.myuserapp.domain.repository.UserRepository
import com.innocv.myuserapp.domain.usecase.ConsultUserListUseCaseImpl
import com.innocv.myuserapp.feature.main.viewmodel.MainViewModel
import com.innocv.myuserapp.feature.main.viewmodel.MainViewModelInterface
import com.innocv.myuserapp.feature.main.viewmodel.fragment.ListUserViewModel
import com.innocv.myuserapp.feature.main.viewmodel.fragment.ListUserViewModelInterface
import dagger.Module
import dagger.Provides

@Module
class MainModule {

    @Provides
    fun provideMainViewModel(
    ): MainViewModelInterface = MainViewModel()

    @Provides
    fun provideListUserViewModel(
        consultUserListUseCaseImpl: ConsultUserListUseCaseImpl.Builder
    ): ListUserViewModelInterface = ListUserViewModel(consultUserListUseCaseImpl)

    @Provides
    fun provideConsultUserListUseCaseBuilder(
        consultUserRepository: UserRepository,
    ): ConsultUserListUseCaseImpl.Builder = ConsultUserListUseCaseImpl.Builder(consultUserRepository)

}