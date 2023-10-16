package com.test.domain.use_case.get_coins

import com.test.common.Resource
import com.test.domain.model.CoinDomainModel
import com.test.domain.repo.CoinRemoteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException

class GetCoinsUseCase(private val repository: CoinRemoteRepository) {
     operator fun invoke(): Flow<Resource<List<CoinDomainModel>>> = flow{
        try {
            emit(Resource.Loading())
            val coins=repository.getCoins()
            emit(Resource.Success(coins))
        }catch (e:IOException){
            emit(Resource.Error("Couldn't reach server"))
        }catch (ex:Exception){
            emit(Resource.Error(ex.localizedMessage ?: "An unexpected error occured"))
        }
    }
}