package hu.bme.aut.android.hazifeladat.domain.model

import androidx.annotation.DrawableRes
import hu.bme.aut.android.hazifeladat.R


data class Pizza(
    val id: Int,
    val name: String,
    val price: Int,
    val toppings: String,
    @DrawableRes val imageResId: Int
)