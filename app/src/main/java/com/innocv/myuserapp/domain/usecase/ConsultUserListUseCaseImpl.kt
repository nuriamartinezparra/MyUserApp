package com.innocv.myuserapp.domain.usecase

import com.innocv.myuserapp.data.network.model.user.ConsultUserListDataIn
import com.innocv.myuserapp.data.network.model.user.ConsultUserListDataOut
import com.innocv.myuserapp.domain.repository.UserRepository
import com.innocv.myuserapp.domain.service.ServiceResponse
import com.innocv.myuserapp.domain.usecase.base.BaseUseCase
import com.innocv.myuserapp.domain.usecase.base.BaseUseCaseImpl
import com.innocv.myuserapp.domain.usecase.base.UseCaseResponse
import io.reactivex.Single
import javax.inject.Inject

class ConsultUserListUseCaseImpl(
    val builder: Builder
): BaseUseCaseImpl<ConsultUserListDataIn, ConsultUserListDataOut>() {

    private val consultUserListRepository = builder.consultUserListRepository

    override fun executeUseCase(): Single<ServiceResponse<ConsultUserListDataOut>> {
        val consultUserListDataIn = ConsultUserListDataIn(
        )
        return this.consultUserListRepository.execute(consultUserListDataIn)
    }

    class Builder @Inject constructor(
        val consultUserListRepository: UserRepository,
    ) {
        fun build(): BaseUseCase<ConsultUserListDataIn, ConsultUserListDataOut> {
            return ConsultUserListUseCaseImpl(this)
        }
    }

    override fun doOnSuccess(response: ServiceResponse<ConsultUserListDataOut>): UseCaseResponse {
        return UseCaseResponse(true, null)
    }
}