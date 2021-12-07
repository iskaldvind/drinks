package io.iskaldvind.drinks.data.drink

import io.reactivex.Maybe
import io.reactivex.Observable

interface DrinkRepository {

    fun getDrinks(): Observable<List<Drink>>

    fun getDrinkById(id: String): Maybe<Drink>
}