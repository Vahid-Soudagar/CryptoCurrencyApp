package com.vcreate.cryptocurrencyapp.domain.usecase.getcoins

import com.vcreate.cryptocurrencyapp.common.Resource
import com.vcreate.cryptocurrencyapp.data.remote.dto.coindto.toCoin
import com.vcreate.cryptocurrencyapp.domain.model.Coin
import com.vcreate.cryptocurrencyapp.domain.repositories.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val coinRepository: CoinRepository
) {

    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading())
            val coins = coinRepository.getCoins().map { it.toCoin() }
            emit(Resource.Success(coins))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection."))
        }
    }

}