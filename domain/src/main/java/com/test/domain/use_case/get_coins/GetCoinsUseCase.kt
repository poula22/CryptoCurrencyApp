package com.test.domain.use_case.get_coins

import com.test.common.Resource
import com.test.domain.model.CoinDomainModel
import com.test.domain.repo.CoinRemoteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(private val repository: CoinRemoteRepository) {
     operator fun invoke(): Flow<Resource<List<CoinDomainModel>>> = flow{
         emit(Resource.Loading())
         emit(repository.getCoins())
    }
}