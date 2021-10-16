package io.iskaldvind.drinks.data.drink

import io.iskaldvind.drinks.data.drink.datasource.DrinkCacheDataSource
import io.iskaldvind.drinks.data.drink.datasource.DrinkRemoteDataSource
import io.reactivex.Maybe
import io.reactivex.Observable
import javax.inject.Inject

class DrinkRepositoryImpl
@Inject constructor(
    private val cloud: DrinkRemoteDataSource,
    private val cache: DrinkCacheDataSource
): DrinkRepository {

    override fun getDrinks(): Observable<List<Drink>> =
        Observable
            .merge(
                cache
                    .fetchDrinks()
                    .toObservable(),
                cloud
                    .fetchDrinks()
                    .flatMap(cache::retain)
                    .toObservable()
            )

    override fun getDrinkById(id: String): Maybe<Drink> =
        cache
            .fetchDrinkById(id = id)
            .switchIfEmpty(
                cloud.fetchDrinkById(id = id)
            )
}