package io.iskaldvind.drinks.presentation.drink

import io.iskaldvind.drinks.presentation.DrinkViewModel
import io.iskaldvind.drinks.presentation.ScreenView
import moxy.viewstate.strategy.SingleStateStrategy
import moxy.viewstate.strategy.StateStrategyType
import moxy.viewstate.strategy.alias.SingleState

@StateStrategyType(SingleStateStrategy::class)
interface DrinkView : ScreenView {

    @SingleState
    fun showDrink(drink: DrinkViewModel)
}