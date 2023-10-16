package com.test.cryptocurrancyapp.presentation.coin_list

import com.test.domain.model.CoinDomainModel

data class CoinListState(
    val isLoading:Boolean = false,
    val coin:List<CoinDomainModel> = emptyList(),
    val error:String=""
)
