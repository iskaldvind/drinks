package io.iskaldvind.drinks.data.api

import okhttp3.Interceptor
import okhttp3.Response
import io.iskaldvind.drinks.BuildConfig.X_RAPIDADI_HOST
import io.iskaldvind.drinks.BuildConfig.X_RAPIDADI_KEY

object RapidApiInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response =
        chain.proceed(
            chain.request()
                .newBuilder()
                .header("x-rapidapi-host", X_RAPIDADI_HOST)
                .header("x-rapidapi-key", X_RAPIDADI_KEY)
                .build()
        )

}