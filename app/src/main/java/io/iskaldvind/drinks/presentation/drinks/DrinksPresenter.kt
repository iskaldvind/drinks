package io.iskaldvind.drinks.presentation.drinks

import com.github.terrakok.cicerone.Router
import io.iskaldvind.drinks.data.drink.DrinkRepository
import io.iskaldvind.drinks.presentation.DrinkViewModel
import io.iskaldvind.drinks.presentation.drink.DrinkScreen
import io.iskaldvind.drinks.scheduler.Schedulers
import io.reactivex.disposables.CompositeDisposable
import io.iskaldvind.drinks.presentation.DrinkViewModel.Mapper
import moxy.MvpPresenter

class DrinksPresenter(
    private val drinkRepo: DrinkRepository,
    private val router: Router,
    private val schedulers: Schedulers
) : MvpPresenter<DrinksView>() {

    private val disposables = CompositeDisposable()

    fun load() {
        disposables.add(
            drinkRepo
                .getDrinks()
                .observeOn(schedulers.background())
                .map { drinks -> drinks.map(Mapper::map) }
                .observeOn(schedulers.main())
                .subscribeOn(schedulers.background())
                .subscribe(
                    viewState::showDrinks,
                    viewState::showError
                )
        )
    }

    fun displayDrink(drink: DrinkViewModel) {
        router.navigateTo(DrinkScreen(drink.id))
    }

    override fun onDestroy() {
        super.onDestroy()
        disposables.dispose()
    }
}