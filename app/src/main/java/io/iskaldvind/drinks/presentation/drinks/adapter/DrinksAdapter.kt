package io.iskaldvind.drinks.presentation.drinks.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import io.iskaldvind.drinks.presentation.DrinkViewModel
import io.iskaldvind.drinks.R.layout.drink_item

class DrinksAdapter(private val delegate: Delegate?) : ListAdapter<DrinkViewModel, DrinkViewHolder>(DrinkDiff) {

    interface Delegate {
        fun onDrinkPicked(drink: DrinkViewModel)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DrinkViewHolder =
        DrinkViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(drink_item, parent, false)
        )

    override fun onBindViewHolder(holder: DrinkViewHolder, position: Int) {
        holder.bind(getItem(position), delegate)
    }
}