package hu.bme.aut.android.hazifeladat.data.entities

import androidx.annotation.DrawableRes
import androidx.room.Entity
import androidx.room.PrimaryKey
import hu.bme.aut.android.hazifeladat.domain.model.Pizza


@Entity(tableName = "cart_table")
data class PizzaEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val name: String,
    val price:Int,
    val toppings: String,
    @DrawableRes val imageResId: Int
)

fun PizzaEntity.asPizza(): Pizza = Pizza(
    id = id,
    name=name,
    toppings=toppings,
    price=price,
   imageResId = imageResId
)

fun Pizza.asPizzaEntity(): PizzaEntity = PizzaEntity(
    id=0,
    name=name,
    toppings=toppings,
    price=price,
    imageResId = imageResId
)