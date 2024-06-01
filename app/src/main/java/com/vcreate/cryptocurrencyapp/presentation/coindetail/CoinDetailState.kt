package com.vcreate.cryptocurrencyapp.presentation.coindetail

import com.vcreate.cryptocurrencyapp.domain.model.Coin
import com.vcreate.cryptocurrencyapp.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)
