package com.innocv.myuserapp.domain.bm.base

import com.innocv.myuserapp.data.network.model.base.BaseDataOut
import java.io.Serializable

interface BaseBMInterface: Serializable {
    fun fromDataOutToBM(baseDataOut: BaseDataOut?): BaseBMInterface
}