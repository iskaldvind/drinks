package io.iskaldvind.drinks.presentation.drinks

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import io.iskaldvind.drinks.presentation.abs.AbsFragment
import io.iskaldvind.drinks.R.layout.drinks_fragment
import io.iskaldvind.drinks.presentation.drinks.adapter.DrinksAdapter
import io.iskaldvind.drinks.arguments
import io.iskaldvind.drinks.data.drink.DrinkRepository
import io.iskaldvind.drinks.databinding.DrinksFragmentBinding
import io.iskaldvind.drinks.presentation.DrinkViewModel
import moxy.ktx.moxyPresenter
import javax.inject.Inject

class DrinksFragment: AbsFragment(drinks_fragment), DrinksView, DrinksAdapter.Delegate {

    companion object {
        fun newInstance(): Fragment = DrinksFragment()
            .arguments()
    }

    @Inject
    lateinit var drinkRepository: DrinkRepository

    private val presenter: DrinksPresenter by moxyPresenter {
        DrinksPresenter(
            drinkRepo = drinkRepository,
            router = router,
            schedulers = schedulers
        )
    }

    private val adapter = DrinksAdapter(delegate = this)

    private val binding: DrinksFragmentBinding by viewBinding()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recycler.adapter = adapter
        presenter
        presenter.load()
    }

    override fun showDrinks(drinks: List<DrinkViewModel>) {
        adapter.submitList(drinks)
    }

    override fun showError(error: Throwable) {
        Toast.makeText(requireContext(), error.localizedMessage, Toast.LENGTH_SHORT).show()
    }

    override fun onDrinkPicked(drink: DrinkViewModel) {
        presenter.displayDrink(drink)
    }
}