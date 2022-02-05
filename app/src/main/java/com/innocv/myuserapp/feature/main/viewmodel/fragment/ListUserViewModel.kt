package com.innocv.myuserapp.feature.main.viewmodel.fragment

import com.innocv.myuserapp.common.base.viewmodel.BaseViewModel
import com.innocv.myuserapp.domain.usecase.ConsultUserListUseCaseImpl
import javax.inject.Inject

class ListUserViewModel @Inject constructor(
    private val consultUserListUseCaseImpl: ConsultUserListUseCaseImpl.Builder
): BaseViewModel(), ListUserViewModelInterface {
    override fun getUserList() {
        super.executeUseCase(consultUserListUseCaseImpl.build())
    }
}