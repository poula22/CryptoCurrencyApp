package com.test.data.data_source

import com.test.data.remote.CoinPaprikaApi
import com.test.domain.data_source.FakeDataSource
import com.test.domain.model.CoinDomainModel

class FakeDataSourceImpl(private val coinPaprikaApi: CoinPaprikaApi):FakeDataSource {
    override suspend fun getCoins(): List<CoinDomainModel> {
        return emptyList()
    }

}