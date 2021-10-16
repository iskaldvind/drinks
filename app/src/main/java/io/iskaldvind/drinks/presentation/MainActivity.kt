package io.iskaldvind.drinks.presentation

import android.os.Bundle
import com.github.terrakok.cicerone.androidx.AppNavigator
import io.iskaldvind.drinks.presentation.abs.AbsActivity
import io.iskaldvind.drinks.presentation.drinks.DrinksScreen

class MainActivity : AbsActivity() {

    private val navigator = AppNavigator(this, android.R.id.content)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        savedInstanceState ?: router.newRootScreen(DrinksScreen)
    }

    override fun onPause() {
        super.onPause()
        navigatorHolder.removeNavigator()
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }
}