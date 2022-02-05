package com.innocv.myuserapp.domain.usecase.base

import com.innocv.myuserapp.domain.service.ServiceResponse
import com.innocv.myuserapp.data.network.model.base.BaseDataIn
import com.innocv.myuserapp.data.network.model.base.BaseDataOut
import io.reactivex.Single
import java.util.concurrent.Future

abstract class BaseUseCaseImpl<Type : BaseDataIn, Params: BaseDataOut>: BaseUseCase<Type, Params> {

    override fun execute(): Future<UseCaseResponse>? {
        //Ejecuta el caso de uso hijo
        val useCaseResult = this.executeUseCase()
        val useCaseResponse = useCaseResult.map { serviceResponse ->
            //Lo envuelvo en una respuesta de UseCase
            this.checkServiceResponse(serviceResponse)
        }
        //Devuelve la respuesta en un Future (objeto que es observado)
        return useCaseResponse.toFuture()
    }

    abstract override fun executeUseCase(): Single<ServiceResponse<Params>>

    abstract fun doOnSuccess(response: ServiceResponse<Params>): UseCaseResponse

    open fun doOnError(response: ServiceResponse<Params>): UseCaseResponse {
        throw Exception()
    }

    private fun checkServiceResponse(serviceResponse: ServiceResponse<Params>): UseCaseResponse {
        try {
            if (serviceResponse.success) {
                return this.doOnSuccess(serviceResponse)
            } else {
                return this.doOnError(serviceResponse)
            }
        } catch (exception: Exception) {
            return UseCaseResponse(false, null)
        }
    }
}

