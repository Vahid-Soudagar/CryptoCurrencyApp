package com.vcreate.cryptocurrencyapp.di

import com.vcreate.cryptocurrencyapp.common.Constants
import com.vcreate.cryptocurrencyapp.data.remote.services.CoinPaprikaApiService
import com.vcreate.cryptocurrencyapp.data.repositories.CoinRepositoryImplementation
import com.vcreate.cryptocurrencyapp.domain.repositories.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providePaprikaApiService() : CoinPaprikaApiService {
        return Retrofit
            .Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinPaprikaApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinRepository(apiService: CoinPaprikaApiService) : CoinRepository{
        return CoinRepositoryImplementation(apiService)
    }


}