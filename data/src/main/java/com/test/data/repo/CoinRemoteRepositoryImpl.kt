package com.test.data.repo

import com.test.domain.data_source.CoinRemoteDataSource
import com.test.domain.model.CoinDetailDomainModel
import com.test.domain.model.CoinDomainModel
import com.test.domain.repo.CoinRemoteRepository

class CoinRemoteRepositoryImpl(private val coinRemoteRepository: CoinRemoteDataSource): CoinRemoteRepository {
    override suspend fun getCoins(): List<CoinDomainModel> {
        return coinRemoteRepository.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDomainModel {
        return coinRemoteRepository.getCoinById(coinId)
    }
}