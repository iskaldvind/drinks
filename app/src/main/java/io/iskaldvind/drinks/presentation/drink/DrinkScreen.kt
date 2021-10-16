package io.iskaldvind.drinks.presentation.drink

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.androidx.FragmentScreen

class DrinkScreen(private val id: String) : FragmentScreen {

    override fun createFragment(factory: FragmentFactory): Fragment =
        DrinkFragment.newInstance(id = id)
}