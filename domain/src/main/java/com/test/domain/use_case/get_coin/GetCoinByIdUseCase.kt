package com.test.domain.use_case.get_coin

import com.test.common.Resource
import com.test.domain.model.CoinDetailDomainModel
import com.test.domain.repo.CoinRemoteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException

class GetCoinByIdUseCase(private val repository: CoinRemoteRepository) {
    operator fun invoke(coinId:String): Flow<Resource<CoinDetailDomainModel>> = flow{
            emit(Resource.Loading())
            emit(repository.getCoinById(coinId))
    }
}