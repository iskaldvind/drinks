package io.iskaldvind.drinks

import io.iskaldvind.drinks.data.drink.Drink
import io.iskaldvind.drinks.data.drink.DrinkRepositoryImpl
import io.iskaldvind.drinks.presentation.drink.DrinkPresenter
import io.iskaldvind.drinks.scheduler.DefaultSchedulers
import io.iskaldvind.drinks.scheduler.Schedulers
import io.reactivex.Maybe
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class DrinkPresenterTest {

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

    private lateinit var presenter: DrinkPresenter

    @Mock
    private lateinit var repository: DrinkRepositoryImpl

    private var schedulers: Schedulers = DefaultSchedulers()


    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = DrinkPresenter(id, repository, schedulers)
    }

    @Test
    fun getDrink_Test() {
        Mockito.`when`(repository.getDrinkById(id)).thenReturn(Maybe.just(drink))
        presenter.load()
        Mockito.verify(repository, Mockito.times(1)).getDrinkById(id)
    }
}