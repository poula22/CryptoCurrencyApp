package com.test.domain.repo

import com.test.common.Resource
import com.test.domain.model.CoinDetailDomainModel
import com.test.domain.model.CoinDomainModel

interface CoinRemoteRepository {
    suspend fun getCoins():Resource<List<CoinDomainModel>>
    suspend fun getCoinById(coinId:String): Resource<CoinDetailDomainModel>
}