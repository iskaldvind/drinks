package io.iskaldvind.drinks.presentation.drink

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import io.iskaldvind.drinks.presentation.abs.AbsFragment
import io.iskaldvind.drinks.R.layout.drink_fragment
import io.iskaldvind.drinks.arguments
import io.iskaldvind.drinks.data.drink.DrinkRepository
import io.iskaldvind.drinks.databinding.DrinkFragmentBinding
import io.iskaldvind.drinks.presentation.DrinkViewModel
import moxy.ktx.moxyPresenter
import javax.inject.Inject

class DrinkFragment : AbsFragment(drink_fragment), DrinkView {

    companion object {
        private const val ID = "DrinkFragment.id"

        fun newInstance(id: String): Fragment =
            DrinkFragment().arguments(ID to id)
    }

    @Inject
    lateinit var drinkRepository: DrinkRepository

    private val id: String by lazy {
        arguments?.getString(ID).orEmpty()
    }

    @Suppress("unused")
    private val presenter: DrinkPresenter by moxyPresenter {
        DrinkPresenter(
            id = id,
            drinkRepo = drinkRepository,
            schedulers = schedulers
        )
    }

    private val binding: DrinkFragmentBinding by viewBinding()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter
        presenter.load()
    }

    override fun showDrink(drink: DrinkViewModel) {
        with(binding) {
            Glide.with(requireContext())
                .load(drink.picture)
                .transition(DrawableTransitionOptions.withCrossFade())
                .apply(
                    RequestOptions
                        .circleCropTransform()
                )
                .into(image)
            name.text = drink.name
            glass.text = drink.glass
            description.text = drink.instructions
            val ingredientsText = drink.ingredients.joinToString("\n") { it.first }
            ingredients.text = ingredientsText
            val amountsText = drink.ingredients.joinToString("\n") { it.second }
            amounts.text = amountsText
        }
    }

    override fun showError(error: Throwable) {
        Toast.makeText(requireContext(), error.localizedMessage, Toast.LENGTH_SHORT).show()
    }
}