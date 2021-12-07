package io.iskaldvind.drinks.data.drink.datasource

import io.iskaldvind.drinks.data.drink.Drink
import io.reactivex.Maybe
import io.reactivex.Single

interface DrinkRemoteDataSource {

    fun fetchDrinks(): Single<List<Drink>>

    fun fetchDrinkById(id: String): Maybe<Drink>
}