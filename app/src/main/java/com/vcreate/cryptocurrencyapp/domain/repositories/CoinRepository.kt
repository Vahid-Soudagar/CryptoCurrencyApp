package com.vcreate.cryptocurrencyapp.domain.repositories

import com.vcreate.cryptocurrencyapp.data.remote.dto.coindetaildto.CoinDetailDto
import com.vcreate.cryptocurrencyapp.data.remote.dto.coindto.CoinDto

interface CoinRepository {

    suspend fun getCoins() : List<CoinDto>

    suspend fun getCoinById(coinId: String) : CoinDetailDto

}