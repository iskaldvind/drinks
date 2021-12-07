package io.iskaldvind.drinks.presentation.drinks

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.androidx.FragmentScreen

object DrinksScreen : FragmentScreen {

    override fun createFragment(factory: FragmentFactory): Fragment =
        DrinksFragment.newInstance()
}