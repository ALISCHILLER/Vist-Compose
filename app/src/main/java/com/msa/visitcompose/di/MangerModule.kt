package com.msa.visitcompose.di

import com.msa.visitcompose.data.manager.LocalUserMangerImpl
import com.msa.visitcompose.domain.manager.LocalUserManger
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class MangerModule {

    @Binds
    @Singleton
    abstract fun bindLocalUserManager(localUserMangerImpl:LocalUserMangerImpl) :LocalUserManger
}