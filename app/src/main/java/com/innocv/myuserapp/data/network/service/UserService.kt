package com.innocv.myuserapp.domain.service

import com.innocv.myuserapp.data.network.api.UserApiService
import com.innocv.myuserapp.data.network.model.user.ConsultUserListDataIn
import com.innocv.myuserapp.data.network.model.user.ConsultUserListDataOut
import com.innocv.myuserapp.domain.repository.UserRepository
import com.innocv.myuserapp.domain.service.base.BaseService
import io.reactivex.Single
import retrofit2.Response
import javax.inject.Inject

class UserService @Inject constructor(
    private val apiService: UserApiService
) : BaseService<ConsultUserListDataIn, ConsultUserListDataOut>(), UserRepository {

    override fun executeService(dataIn: ConsultUserListDataIn): Single<Response<ConsultUserListDataOut>> {
        return this.apiService.consultUserList()
    }
}