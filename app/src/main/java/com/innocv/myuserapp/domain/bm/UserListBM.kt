package com.innocv.myuserapp.domain.bm

import com.innocv.myuserapp.data.network.model.base.BaseDataOut
import com.innocv.myuserapp.data.network.model.user.ConsultUserListDataOut
import com.innocv.myuserapp.domain.bm.base.BaseBM
import com.innocv.myuserapp.domain.bm.base.BaseBMInterface

class UserListBM:  BaseBM(), UserListBMInterface {

    override fun fromDataOutToBM(baseDataOut: BaseDataOut?): BaseBMInterface {
        with(baseDataOut as ConsultUserListDataOut){

        }
        return this
    }


}