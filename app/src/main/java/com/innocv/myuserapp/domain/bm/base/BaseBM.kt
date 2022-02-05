package com.innocv.myuserapp.domain.bm.base

import com.innocv.myuserapp.data.network.model.base.BaseDataOut
import java.io.Serializable

abstract class BaseBM: BaseBMInterface, Serializable {
    override fun fromDataOutToBM(baseDataOut: BaseDataOut?): BaseBMInterface {
        return this
    }
}