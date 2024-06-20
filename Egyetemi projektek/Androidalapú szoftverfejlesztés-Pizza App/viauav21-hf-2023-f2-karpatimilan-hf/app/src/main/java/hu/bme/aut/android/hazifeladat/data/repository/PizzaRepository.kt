package hu.bme.aut.android.hazifeladat.data.repository

import hu.bme.aut.android.hazifeladat.domain.model.Pizza

interface PizzaRepository {
    suspend fun insertPizza(pizza: Pizza)
    suspend fun deletePizza(pizza: Pizza)
    suspend fun getPizzaById(id: Int): Pizza
    suspend fun getAllPizzas(): List<Pizza>
    suspend fun updatePizza(updatedPizza: Pizza)

}