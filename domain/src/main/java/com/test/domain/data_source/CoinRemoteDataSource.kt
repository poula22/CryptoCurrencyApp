package com.test.domain.data_source

import com.test.domain.model.CoinDetailDomainModel
import com.test.domain.model.CoinDomainModel

interface CoinRemoteDataSource {
    suspend fun getCoins():List<CoinDomainModel>
    suspend fun getCoinById(coinId:String):CoinDetailDomainModel
}