package io.iskaldvind.drinks.data.drink.datasource

import io.iskaldvind.drinks.data.drink.Drink
import io.iskaldvind.drinks.data.storage.Storage
import io.reactivex.Maybe
import io.reactivex.Single
import javax.inject.Inject

class DrinkCacheDataSourceImpl
@Inject constructor(
    private val storage: Storage
): DrinkCacheDataSource {

    override fun fetchDrinks(): Single<List<Drink>> =
        storage
            .getDrinkDao()
            .getDrinks()
            .firstOrError()

    override fun fetchDrinkById(id: String): Maybe<Drink> =
        storage
            .getDrinkDao()
            .getDrinkById(id = id)
            .toMaybe()

    override fun retain(drinks: List<Drink>): Single<List<Drink>> =
        storage
            .getDrinkDao()
            .retain(drinks)
            .andThen(
                fetchDrinks()
            )
}