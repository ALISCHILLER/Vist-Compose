package com.msa.visitcompose.domain.usecases.app_entry

import com.msa.visitcompose.domain.manager.LocalUserManger
import javax.inject.Inject

class SaveAppEntry @Inject constructor(
    private val localUserManger: LocalUserManger
){

    suspend operator fun invoke(){
        localUserManger.saveAppEntry()
    }
}