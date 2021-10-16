package io.iskaldvind.drinks.data.storage

import androidx.room.Database
import androidx.room.RoomDatabase
import io.iskaldvind.drinks.data.drink.Drink

@Database(exportSchema = false, entities = [Drink::class], version = 1)
abstract class Storage: RoomDatabase() {

    abstract fun getDrinkDao(): DrinkDao
}