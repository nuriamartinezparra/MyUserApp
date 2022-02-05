package com.innocv.myuserapp.domain.usecase.base

import com.innocv.myuserapp.domain.service.ServiceResponse
import com.innocv.myuserapp.data.network.model.base.BaseDataOut
import io.reactivex.Single
import java.util.concurrent.Future

interface BaseUseCase<Type, Params: BaseDataOut>{

    fun execute(): Future<UseCaseResponse>?

    fun executeUseCase(): Single<ServiceResponse<Params>>

}