package com.test.cryptocurrancyapp.presentation.coin_detail

import com.test.domain.model.CoinDetailDomainModel

data class CoinDetailState(
    val isLoading:Boolean=false,
    val coin:CoinDetailDomainModel?=null,
    val error:String=""
)