package com.test.domain.data_source

import com.test.domain.model.CoinDomainModel

interface FakeDataSource {
    suspend fun getCoins():List<CoinDomainModel>
}