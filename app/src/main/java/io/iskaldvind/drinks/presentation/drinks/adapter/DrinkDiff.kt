package io.iskaldvind.drinks.presentation.drinks.adapter

import androidx.recyclerview.widget.DiffUtil
import io.iskaldvind.drinks.presentation.DrinkViewModel

object DrinkDiff : DiffUtil.ItemCallback<DrinkViewModel>() {

    private val payload = Any()

    override fun areItemsTheSame(oldItem: DrinkViewModel, newItem: DrinkViewModel): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: DrinkViewModel, newItem: DrinkViewModel): Boolean =
        oldItem == newItem

    override fun getChangePayload(oldItem: DrinkViewModel, newItem: DrinkViewModel) =
        payload
}