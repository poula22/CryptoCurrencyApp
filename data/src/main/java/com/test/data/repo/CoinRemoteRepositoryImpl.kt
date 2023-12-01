package com.test.data.repo

import com.test.common.Resource
import com.test.domain.data_source.CoinRemoteDataSource
import com.test.domain.model.CoinDetailDomainModel
import com.test.domain.model.CoinDomainModel
import com.test.domain.repo.CoinRemoteException
import com.test.domain.repo.CoinRemoteRepository
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class CoinRemoteRepositoryImpl @Inject constructor(
    private val coinRemoteDataSource: CoinRemoteDataSource
) : CoinRemoteRepository {
    override suspend fun getCoins(): Resource<List<CoinDomainModel>> {
        return try {
            val response = coinRemoteDataSource.getCoins()
            return Resource.Success(response)
        } catch (e: IOException) {
            return Resource.Error(CoinRemoteException.IO.message)
        } catch (e: HttpException) {
            if (e.code() == 404) {
                return Resource.Error(CoinRemoteException._404.message)
            } else if (e.code() == 408) {
                return Resource.Error(CoinRemoteException._408.message)
            } else {
                return Resource.Error(CoinRemoteException.OTHER.message)
            }
        } catch (ex: Exception) {
            Resource.Error(ex.localizedMessage ?: "An unexpected error occured")
        }
    }

    override suspend fun getCoinById(coinId: String): Resource<CoinDetailDomainModel> {
        return try {
            val response = coinRemoteDataSource.getCoinById(coinId)
            return Resource.Success(response)
        } catch (e: IOException) {
            return Resource.Error(CoinRemoteException.IO.message)
        } catch (e: HttpException) {
            if (e.code() == 404) {
                return Resource.Error(CoinRemoteException._404.message)
            } else if (e.code() == 408) {
                return Resource.Error(CoinRemoteException._408.message)
            } else {
                return Resource.Error(CoinRemoteException.OTHER.message)
            }
        } catch (ex: Exception) {
            Resource.Error(ex.localizedMessage ?: "An unexpected error occured")
        }
    }
}