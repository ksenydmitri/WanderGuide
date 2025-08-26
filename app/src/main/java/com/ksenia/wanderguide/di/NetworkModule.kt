package com.ksenia.wanderguide.di

import com.ksenia.wanderguide.data.datasource.remote.CurrencyApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import kotlin.jvm.java

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl("https://localhost:8080/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

    @Provides
    fun provideCurrencyApi(retrofit: Retrofit): CurrencyApi =
        retrofit.create(CurrencyApi::class.java)
}