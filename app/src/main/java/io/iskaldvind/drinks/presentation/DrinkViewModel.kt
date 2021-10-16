package io.iskaldvind.drinks.presentation

import io.iskaldvind.drinks.data.drink.Drink

data class DrinkViewModel (
    val id: String,
    val name: String,
    val picture: String,
    val glass: String,
    val instructions: String,
    val ingredients: List<Pair<String, String>>
) {

    object Mapper {
        fun map(drink: Drink): DrinkViewModel {
            val ingredients: MutableList<Pair<String, String>> = mutableListOf()
            ingredients.addIfNotNull(drink.ingredient1, drink.measure1)
            ingredients.addIfNotNull(drink.ingredient2, drink.measure2)
            ingredients.addIfNotNull(drink.ingredient3, drink.measure3)
            ingredients.addIfNotNull(drink.ingredient4, drink.measure4)
            ingredients.addIfNotNull(drink.ingredient5, drink.measure5)
            ingredients.addIfNotNull(drink.ingredient6, drink.measure6)
            ingredients.addIfNotNull(drink.ingredient7, drink.measure7)
            ingredients.addIfNotNull(drink.ingredient8, drink.measure8)
            ingredients.addIfNotNull(drink.ingredient9, drink.measure9)
            ingredients.addIfNotNull(drink.ingredient10, drink.measure10)
            ingredients.addIfNotNull(drink.ingredient11, drink.measure11)
            ingredients.addIfNotNull(drink.ingredient12, drink.measure12)
            ingredients.addIfNotNull(drink.ingredient13, drink.measure13)
            ingredients.addIfNotNull(drink.ingredient14, drink.measure14)
            ingredients.addIfNotNull(drink.ingredient15, drink.measure15)
            return DrinkViewModel(
                id = drink.id,
                name = drink.name,
                picture = drink.picture,
                glass = drink.glass,
                instructions = drink.instructions,
                ingredients = ingredients.toList()
            )
        }

        private fun MutableList<Pair<String, String>>.addIfNotNull(property: String?, amount: String?) {
            if (property != null && amount != null) this.add(Pair(property, amount))
        }
    }

}