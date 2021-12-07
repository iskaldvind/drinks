package io.iskaldvind.drinks.data.di

import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import io.iskaldvind.drinks.data.drink.DrinkRepository
import io.iskaldvind.drinks.data.drink.DrinkRepositoryImpl
import io.iskaldvind.drinks.data.drink.datasource.DrinkCacheDataSource
import io.iskaldvind.drinks.data.drink.datasource.DrinkCacheDataSourceImpl
import io.iskaldvind.drinks.data.drink.datasource.DrinkRemoteDataSource
import io.iskaldvind.drinks.data.drink.datasource.DrinkRemoteDataSourceImpl
import io.iskaldvind.drinks.presentation.drink.DrinkFragment
import io.iskaldvind.drinks.presentation.drinks.DrinksFragment
import javax.inject.Singleton

@Module
interface DrinkModule {

    @ContributesAndroidInjector
    fun bindDrinkFragment(): DrinkFragment

    @ContributesAndroidInjector
    fun bindDrinksFragment(): DrinksFragment

    @Singleton
    @Binds
    fun bindDrinkRepository(drinkRepositoryImpl: DrinkRepositoryImpl): DrinkRepository

    @Singleton
    @Binds
    fun bindDrinkRemoteDataSource(drinkRemoteDataSourceImpl: DrinkRemoteDataSourceImpl): DrinkRemoteDataSource

    @Singleton
    @Binds
    fun bindDrinkCacheDataSource(drinkCacheDataSourceImpl: DrinkCacheDataSourceImpl): DrinkCacheDataSource
}