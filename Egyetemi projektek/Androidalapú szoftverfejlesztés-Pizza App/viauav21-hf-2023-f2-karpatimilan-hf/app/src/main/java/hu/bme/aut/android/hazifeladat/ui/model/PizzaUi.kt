package hu.bme.aut.android.hazifeladat.ui.model

import hu.bme.aut.android.hazifeladat.domain.model.Pizza

import androidx.annotation.DrawableRes
import hu.bme.aut.android.hazifeladat.R

data class PizzaUi(
    val id: Int = 0,
    val name: String = "",
    val toppings: String = "",
    val price: Int = 0,
    @DrawableRes val imageResId: Int = R.drawable.crossed
)

fun Pizza.asPizzaUi(): PizzaUi = PizzaUi(
    id = id,
    name = name,
    price = price,
    toppings = toppings,
    imageResId = imageResId // Add the imageResId property
)

fun PizzaUi.asPizza(): Pizza = Pizza(
    id = id,
    name = name,
    price = price,
    toppings = toppings,
    imageResId = imageResId // Add the imageResId property
)