package io.iskaldvind.drinks.presentation.drinks

import io.iskaldvind.drinks.presentation.DrinkViewModel
import moxy.MvpView
import moxy.viewstate.strategy.alias.SingleState

interface DrinksView : MvpView {

    @SingleState
    fun showDrinks(drinks: List<DrinkViewModel>)

    @SingleState
    fun showError(error: Throwable)
}