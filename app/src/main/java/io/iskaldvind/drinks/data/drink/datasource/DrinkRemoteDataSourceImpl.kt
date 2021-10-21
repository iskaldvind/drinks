package io.iskaldvind.drinks.data.drink.datasource

import io.iskaldvind.drinks.data.api.RapidApi
import io.iskaldvind.drinks.data.drink.Drink
import io.reactivex.Maybe
import io.reactivex.Single
import java.lang.RuntimeException
import javax.inject.Inject

class DrinkRemoteDataSourceImpl
@Inject constructor(
    private val rapidApi: RapidApi
): DrinkRemoteDataSource {

    override fun fetchDrinks(): Single<List<Drink>> =
        rapidApi
            .fetchDrinks()
            .map { it.drinks }
            .map { it.sortedBy(Drink::name) }

    override fun fetchDrinkById(id: String): Maybe<Drink> =
        rapidApi
            .fetchDrinkById(id = id)
            .map {
                if (it.drinks.isEmpty()) throw RuntimeException("No drinks found") else it.drinks[0]
            }
            .toMaybe()
}