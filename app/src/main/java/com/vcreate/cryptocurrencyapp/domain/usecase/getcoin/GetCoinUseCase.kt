package com.vcreate.cryptocurrencyapp.domain.usecase.getcoin

import com.vcreate.cryptocurrencyapp.common.Resource
import com.vcreate.cryptocurrencyapp.data.remote.dto.coindetaildto.toCoinDetail
import com.vcreate.cryptocurrencyapp.data.remote.dto.coindto.toCoin
import com.vcreate.cryptocurrencyapp.domain.model.Coin
import com.vcreate.cryptocurrencyapp.domain.model.CoinDetail
import com.vcreate.cryptocurrencyapp.domain.repositories.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val coinRepository: CoinRepository
) {

    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading())
            val coin = coinRepository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success(coin))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection."))
        }
    }

}