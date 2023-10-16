package com.test.domain.repo

import com.test.domain.model.CoinDetailDomainModel
import com.test.domain.model.CoinDomainModel

interface CoinRemoteRepository {
    suspend fun getCoins():List<CoinDomainModel>
    suspend fun getCoinById(coinId:String): CoinDetailDomainModel
}