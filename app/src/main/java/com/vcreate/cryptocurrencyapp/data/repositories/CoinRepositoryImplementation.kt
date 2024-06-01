package com.vcreate.cryptocurrencyapp.data.repositories

import com.vcreate.cryptocurrencyapp.data.remote.dto.coindetaildto.CoinDetailDto
import com.vcreate.cryptocurrencyapp.data.remote.dto.coindto.CoinDto
import com.vcreate.cryptocurrencyapp.data.remote.services.CoinPaprikaApiService
import com.vcreate.cryptocurrencyapp.domain.repositories.CoinRepository
import javax.inject.Inject

class CoinRepositoryImplementation @Inject constructor(
    private val coinPaprikaApiService: CoinPaprikaApiService
) : CoinRepository {


    override suspend fun getCoins(): List<CoinDto> {
        return coinPaprikaApiService.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return coinPaprikaApiService.getCoinById(coinId = coinId)
    }


}