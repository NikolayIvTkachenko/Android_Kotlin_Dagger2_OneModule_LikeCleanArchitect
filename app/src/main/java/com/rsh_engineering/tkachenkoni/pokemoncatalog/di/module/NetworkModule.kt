package com.rsh_engineering.tkachenkoni.pokemoncatalog.di.module

import com.rsh_engineering.tkachenkoni.pokemoncatalog.data.network.PokemonApi
import com.rsh_engineering.tkachenkoni.pokemoncatalog.di.scope.AppScope
import com.rsh_engineering.tkachenkoni.pokemoncatalog.presentation.BASE_URL
import com.rsh_engineering.tkachenkoni.pokemoncatalog.presentation.TIMEOUT_REQUEST
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 *
 * Created by Nikolay Tkachenko on 01, October, 2020
 *
 */
@Module
class NetworkModule {
    @AppScope
    @Provides
    fun provideHttpLogging(): HttpLoggingInterceptor {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return loggingInterceptor
    }

    @AppScope
    @Provides
    fun provideOkhttpClient(interceptor: HttpLoggingInterceptor): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .connectTimeout(TIMEOUT_REQUEST, TimeUnit.SECONDS)
            .readTimeout(TIMEOUT_REQUEST, TimeUnit.SECONDS)
            .writeTimeout(TIMEOUT_REQUEST, TimeUnit.SECONDS)
            .build()

    @AppScope
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient) =
        Retrofit.Builder().client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())


    @AppScope
    @Provides
    fun provideFeedService(builder: Retrofit.Builder) =
        builder.baseUrl(BASE_URL).build().create(PokemonApi::class.java)
}