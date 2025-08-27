package com.ksenia.wanderguide.di

import com.ksenia.wanderguide.domain.repository.CurrencyRepository
import com.ksenia.wanderguide.domain.usecase.ConvertCurrencyUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    fun provideConvertCurrencyUseCase(currencyRepository: CurrencyRepository):
            ConvertCurrencyUseCase {
        return ConvertCurrencyUseCase(currencyRepository)
    }
}