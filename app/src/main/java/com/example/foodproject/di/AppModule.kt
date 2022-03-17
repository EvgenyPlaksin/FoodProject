package com.example.foodproject.di

import com.example.foodproject.api.ApiService
import com.example.foodproject.utils.ConstandVar
import dagger.Module
import dagger.Provides

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

// жестоко юзаю хилт и ретрофит, тебе тут ничего менять не надо

//@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Provides
    fun provideBaseUrl() = ConstandVar.BASE_URL

    @Provides
    @Singleton
    fun provideRetrofitInstance(BASE_URL: String): ApiService =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)

}

