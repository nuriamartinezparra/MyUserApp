package com.innocv.myuserapp.domain.service.base

import com.innocv.myuserapp.domain.service.ServiceResponse
import com.innocv.myuserapp.data.network.model.base.BaseDataIn
import com.innocv.myuserapp.data.network.model.base.BaseDataOut
import com.innocv.myuserapp.domain.repository.base.BaseRepository
import io.reactivex.Single
import retrofit2.Response

abstract class BaseService<T: BaseDataIn, P: BaseDataOut>: BaseRepository<T, P> {

    abstract override fun executeService(dataIn: T): Single<Response<P>>

    override fun execute(dataIn: T): Single<ServiceResponse<P>>{
        return this.executeService(dataIn).map { response ->
            this.checkServiceResponse(response)
        }
    }

    override fun mapSpecificError(response: Response<P>): ServiceResponse<P> {
        throw Exception()
    }

    private fun checkServiceResponse(response: Response<P>): ServiceResponse<P> {
        try {
            //Check if the service has returned an error http status code
            if (!response.isSuccessful) throw Exception()
            //Save Response body in a variable
            val dataOut = response.body()
            //Check if the return code means success or failure
            return ServiceResponse(true, response.body())
        } catch (exception: Exception) {
            return ServiceResponse(false, null)
        }
    }
}