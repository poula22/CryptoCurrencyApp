package com.test.cryptocurrancyapp.di

import com.test.data.data_source.CoinRemoteDataSourceImpl
import com.test.data.remote.ApiManager
import com.test.data.remote.CoinPaprikaApi
import com.test.data.repo.CoinRemoteRepositoryImpl
import com.test.domain.data_source.CoinRemoteDataSource
import com.test.domain.repo.CoinRemoteRepository
import com.test.domain.use_case.get_coin.GetCoinByIdUseCase
import com.test.domain.use_case.get_coins.GetCoinsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {





    @Provides
    @Singleton
    fun providePaprikaApi():CoinPaprikaApi{
        return ApiManager.getPaprikaApi()
    }

    @Provides
    @Singleton
    fun provideCoinDataSource(api:CoinPaprikaApi):CoinRemoteDataSource{
        return CoinRemoteDataSourceImpl(api)
    }

    @Provides
    @Singleton
    fun provideCoinRepository(dataSource:CoinRemoteDataSource):CoinRemoteRepository{
        return CoinRemoteRepositoryImpl(dataSource)
    }

    @Provides
    fun getCoinByIdUseCase(repository: CoinRemoteRepository):GetCoinByIdUseCase{
        return GetCoinByIdUseCase(repository)
    }

    @Provides
    fun getCoins(repository: CoinRemoteRepository):GetCoinsUseCase{
        return GetCoinsUseCase(repository)
    }

}