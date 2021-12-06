package io.iskaldvind.drinks

import io.iskaldvind.drinks.data.drink.Drink
import io.iskaldvind.drinks.data.drink.DrinkRepository
import io.iskaldvind.drinks.data.drink.DrinkRepositoryImpl
import io.iskaldvind.drinks.data.drink.datasource.DrinkCacheDataSource
import io.iskaldvind.drinks.data.drink.datasource.DrinkRemoteDataSource
import io.reactivex.Maybe
import io.reactivex.Observable
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class RepositoryTest {

    private val drinks = listOf<Drink>()
    private val id = "0"
    private val drink = Drink(
        glass = "",
        id = "",
        name = "",
        picture = "",
        instructions = "",
        ingredient1 = "",
        measure1 = "",
        ingredient2 = null,
        measure2 = null,
        ingredient3 = null,
        measure3 = null,
        ingredient4 = null,
        measure4 = null,
        ingredient5 = null,
        measure5 = null,
        ingredient6 = null,
        measure6 = null,
        ingredient7 = null,
        measure7 = null,
        ingredient8 = null,
        measure8 = null,
        ingredient9 = null,
        measure9 = null,
        ingredient10 = null,
        measure10 = null,
        ingredient11 = null,
        measure11 = null,
        ingredient12 = null,
        measure12 = null,
        ingredient13 = null,
        measure13 = null,
        ingredient14 = null,
        measure14 = null,
        ingredient15 = null,
        measure15 = null
    )

    private lateinit var repository: DrinkRepository

    @Mock
    private lateinit var cloud: DrinkRemoteDataSource

    @Mock
    private lateinit var cache: DrinkCacheDataSource

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        repository = DrinkRepositoryImpl(cloud = cloud, cache = cache)
    }

    @Test
    fun searchDrinks_Test() {
        Mockito.`when`(cloud.fetchDrinks()).thenReturn(Single.just(drinks))
        Mockito.`when`(cache.fetchDrinks()).thenReturn(Single.just(drinks))
        repository.getDrinks()
        Mockito.verify(cloud, Mockito.times(1)).fetchDrinks()
        Mockito.verify(cache, Mockito.times(1)).fetchDrinks()
    }

    @Test
    fun getDrinkById_Test() {
        Mockito.`when`(cloud.fetchDrinkById(id)).thenReturn(Maybe.just(drink))
        Mockito.`when`(cache.fetchDrinkById(id)).thenReturn(Maybe.just(drink))
        repository.getDrinkById(id)
        Mockito.verify(cloud, Mockito.times(1)).fetchDrinkById(id)
        Mockito.verify(cache, Mockito.times(1)).fetchDrinkById(id)
    }
}