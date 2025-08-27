package com.ksenia.wanderguide.data.datasource.remote

import com.ksenia.wanderguide.data.model.dto.CurrencyResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface CurrencyApi {

    @GET("latest")
    suspend fun getRates(): CurrencyResponse
}