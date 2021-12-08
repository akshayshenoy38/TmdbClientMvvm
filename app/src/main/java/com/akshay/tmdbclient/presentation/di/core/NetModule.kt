package com.akshay.tmdbclient.presentation.di.core

import com.akshay.tmdbclient.data.api.TmdbService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetModule(private val baseUrl:String) {


    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .build()
    }

    @Singleton
    @Provides
    fun providetmdbService(retrofit:Retrofit): TmdbService {
        return retrofit.create(TmdbService::class.java)
    }
}