package io.iskaldvind.drinks.presentation.drinks.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import by.kirich1409.viewbindingdelegate.viewBinding
import io.iskaldvind.drinks.click
import io.iskaldvind.drinks.databinding.DrinkItemBinding
import io.iskaldvind.drinks.presentation.DrinkViewModel
import io.iskaldvind.drinks.setStartDrawableCircleImageFromUri

class DrinkViewHolder(view: View): ViewHolder(view) {

    private val binding: DrinkItemBinding by viewBinding()

    fun bind(drink: DrinkViewModel, delegate: DrinksAdapter.Delegate?) {
        with(binding) {
            header.setStartDrawableCircleImageFromUri(drink.picture)
            header.text = drink.name
            complexityValue.text = drink.ingredients.size.toString()
            root.click { delegate?.onDrinkPicked(drink) }
        }
    }
}