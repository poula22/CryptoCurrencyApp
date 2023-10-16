package com.test.data.data_source

import com.test.data.remote.CoinPaprikaApi
import com.test.data.toCoinDetailsDomain
import com.test.data.toCoinDomain
import com.test.domain.data_source.CoinRemoteDataSource
import com.test.domain.model.CoinDetailDomainModel
import com.test.domain.model.CoinDomainModel

class CoinRemoteDataSourceImpl(private val coinApi:CoinPaprikaApi): CoinRemoteDataSource {
    override suspend fun getCoins(): List<CoinDomainModel> {
        return coinApi.getCoins().map { it.toCoinDomain() }
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDomainModel {
        return coinApi.getCoinById(coinId).toCoinDetailsDomain()
    }

}