package com.vcreate.cryptocurrencyapp.data.remote.services

import com.vcreate.cryptocurrencyapp.data.remote.dto.coindto.CoinDto
import com.vcreate.cryptocurrencyapp.data.remote.dto.coindetaildto.CoinDetailDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPaprikaApiService {

    @GET("v1/coins")
    suspend fun getCoins() : List<CoinDto>

    @GET("v1/coins/{coinId}")
    suspend fun getCoinById(@Path("coinId") coinId: String): CoinDetailDto

}