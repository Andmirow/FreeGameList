package com.example.freegamelist.di

import com.example.freegamelist.data.retrofit.GameApi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module

class RetrofitModule {

    @Provides
    fun provideGsonConverter(): GsonConverterFactory = GsonConverterFactory.create()

    @Provides
    fun provideRxJava2CallAdapter() : RxJava2CallAdapterFactory = RxJava2CallAdapterFactory.create()

    @Provides
    fun provideOkHttpClient() : OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        .build()


    @Provides
    fun provideRetrofit(
        gsonConverter: GsonConverterFactory,
        httpClient : OkHttpClient,
        RxJava2CallAdapter : RxJava2CallAdapterFactory
    ) : Retrofit
        = Retrofit.Builder()
            .baseUrl("https://www.freetogame.com/api/")
            .addConverterFactory(gsonConverter)
            .addCallAdapterFactory(RxJava2CallAdapter)
            .client(httpClient)
            .build()


    @Provides
    fun provideGameApi(retrofit : Retrofit) : GameApi = retrofit.create(GameApi::class.java)


}