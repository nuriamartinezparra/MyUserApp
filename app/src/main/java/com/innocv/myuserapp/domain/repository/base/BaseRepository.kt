package com.innocv.myuserapp.domain.repository.base

import com.innocv.myuserapp.domain.service.ServiceResponse
import com.innocv.myuserapp.data.network.model.base.BaseDataIn
import com.innocv.myuserapp.data.network.model.base.BaseDataOut
import io.reactivex.Single
import retrofit2.Response

interface BaseRepository<T: BaseDataIn,P: BaseDataOut>{
    fun executeService(dataIn: T): Single<Response<P>>
    fun execute(dataIn: T): Single<ServiceResponse<P>>
    fun mapSpecificError(response: Response<P>): ServiceResponse<P>?
}