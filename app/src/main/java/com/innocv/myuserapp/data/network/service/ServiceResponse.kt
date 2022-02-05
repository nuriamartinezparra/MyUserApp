package com.innocv.myuserapp.domain.service

import com.innocv.myuserapp.data.network.model.base.BaseDataOut

class ServiceResponse<P: BaseDataOut>(var success: Boolean, var dataOut: P?)