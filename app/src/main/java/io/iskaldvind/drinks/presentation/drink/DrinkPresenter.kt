package io.iskaldvind.drinks.presentation.drink

import io.iskaldvind.drinks.data.drink.DrinkRepository
import io.iskaldvind.drinks.presentation.DrinkViewModel.Mapper
import io.iskaldvind.drinks.scheduler.Schedulers
import io.reactivex.disposables.CompositeDisposable
import moxy.MvpPresenter

class DrinkPresenter(
    private val id: String,
    private val drinkRepo: DrinkRepository,
    private val schedulers: Schedulers
) : MvpPresenter<DrinkView>() {

    private val disposables = CompositeDisposable()

    fun load() {
        disposables.add(
            drinkRepo
                .getDrinkById(id = id)
                .map(Mapper::map)
                .observeOn(schedulers.main())
                .subscribeOn(schedulers.background())
                .subscribe(
                    viewState::showDrink,
                    viewState::showError
                )
        )
    }

    override fun onDestroy() {
        super.onDestroy()
        disposables.dispose()
    }
}