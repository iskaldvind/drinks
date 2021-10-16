package io.iskaldvind.drinks.data.di

import dagger.Module
import dagger.Provides
import io.iskaldvind.drinks.data.api.RapidApi
import io.iskaldvind.drinks.data.api.RapidApiInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class RapidApiModule {

    @Singleton
    @Provides
    fun provideRapidApi(): RapidApi =
        Retrofit.Builder()
            .baseUrl("https://the-cocktail-db.p.rapidapi.com")
            .client(
                OkHttpClient.Builder()
                    .addInterceptor(RapidApiInterceptor)
                    .addInterceptor(HttpLoggingInterceptor().apply {
                        level = HttpLoggingInterceptor.Level.BODY
                    })
                    .build()
            )
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RapidApi::class.java)
}