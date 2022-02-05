package com.innocv.myuserapp.data.network.api

import com.innocv.myuserapp.data.network.api.ApiConfig.Companion.BASE_URL
import com.innocv.myuserapp.data.network.model.user.ConsultUserListDataOut
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET

interface UserApiService{

    @GET(BASE_URL)
    fun consultUserList(
    ): Single<Response<ConsultUserListDataOut>>

}