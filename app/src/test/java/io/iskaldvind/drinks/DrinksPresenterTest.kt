package io.iskaldvind.drinks

import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router
import io.iskaldvind.drinks.data.drink.Drink
import io.iskaldvind.drinks.data.drink.DrinkRepositoryImpl
import io.iskaldvind.drinks.presentation.drinks.DrinksPresenter
import io.iskaldvind.drinks.scheduler.DefaultSchedulers
import io.iskaldvind.drinks.scheduler.Schedulers
import io.reactivex.Observable
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class DrinksPresenterTest {

    private val drinks = listOf<Drink>()

    private lateinit var presenter: DrinksPresenter

    @Mock
    private lateinit var repository: DrinkRepositoryImpl

    private val router: Router = Cicerone.create().router

    private var schedulers: Schedulers = DefaultSchedulers()



    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = DrinksPresenter(repository, router, schedulers)
    }

    @Test
    fun searchDrinks_Test() {
        Mockito.`when`(repository.getDrinks()).thenReturn(Observable.just(drinks))
        presenter.load()
        Mockito.verify(repository, Mockito.times(1)).getDrinks()
    }
}