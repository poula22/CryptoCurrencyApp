package com.test.cryptocurrancyapp.di

import com.test.common.Constants
import com.test.data.data_source.CoinRemoteDataSourceImpl
import com.test.data.data_source.FakeDataSourceImpl
import com.test.data.remote.ApiManager
import com.test.data.remote.CoinPaprikaApi
import com.test.data.repo.CoinRemoteRepositoryImpl
import com.test.domain.data_source.CoinRemoteDataSource
import com.test.domain.data_source.FakeDataSource
import com.test.domain.repo.CoinRemoteRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {
    companion object{
        @Singleton
        @Provides
        fun provideApiManager():ApiManager{
            return ApiManager(Constants.BASE_URL)
        }
        //solution 1 to ODC Task
        @Singleton
        @Provides
        fun provideFakeDataSource(apiManager: ApiManager):FakeDataSource{
            return FakeDataSourceImpl(apiManager.buildWebService(CoinPaprikaApi::class.java))
        }
    }
    //solution 2 to ODC Task
    @Singleton
    @Binds
    abstract fun provideCoinDataSource(coinRemoteDataSource: CoinRemoteDataSourceImpl):CoinRemoteDataSource
    @Singleton
    @Binds
    abstract fun provideCoinRepository(coinRemoteRepository:CoinRemoteRepositoryImpl):CoinRemoteRepository
}