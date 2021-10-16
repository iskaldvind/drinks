package io.iskaldvind.drinks.data.drink.datasource

import io.iskaldvind.drinks.data.drink.Drink
import io.reactivex.Single

interface DrinkCacheDataSource: DrinkRemoteDataSource {

    fun retain(drinks: List<Drink>): Single<List<Drink>>

}