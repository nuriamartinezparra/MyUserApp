package com.innocv.myuserapp.domain.repository

import com.innocv.myuserapp.data.network.model.user.ConsultUserListDataIn
import com.innocv.myuserapp.data.network.model.user.ConsultUserListDataOut
import com.innocv.myuserapp.domain.repository.base.BaseRepository

interface UserRepository: BaseRepository<ConsultUserListDataIn, ConsultUserListDataOut>