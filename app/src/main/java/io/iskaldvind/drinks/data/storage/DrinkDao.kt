package io.iskaldvind.drinks.data.storage

import androidx.room.*
import io.iskaldvind.drinks.data.drink.Drink
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single

@Dao
interface DrinkDao {

    @Query("SELECT * FROM drinks")
    fun getDrinks(): Observable<List<Drink>>

    @Query("SELECT * FROM drinks WHERE id LIKE :id LIMIT 1")
    fun getDrinkById(id: String): Single<Drink>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun retain(drinks: List<Drink>): Completable

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun retain(drink: Drink): Completable
}