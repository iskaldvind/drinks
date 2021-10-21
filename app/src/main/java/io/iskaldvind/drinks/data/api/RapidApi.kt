package io.iskaldvind.drinks.data.api

import io.iskaldvind.drinks.data.drink.Response
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface RapidApi {

    @GET("/popular.php")
    fun fetchDrinks(): Single<Response>

    @GET("/lookup.php")
    fun fetchDrinkById(@Query("i") id: String): Single<Response>
}