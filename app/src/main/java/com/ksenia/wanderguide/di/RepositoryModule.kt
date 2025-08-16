package com.ksenia.wanderguide.di

import com.ksenia.wanderguide.data.repositoryimpl.CurrencyRepositoryImpl
import com.ksenia.wanderguide.domain.repository.CurrencyRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindCurrencyRepository(
        impl: CurrencyRepositoryImpl
    ): CurrencyRepository
}