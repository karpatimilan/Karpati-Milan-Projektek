package hu.bme.aut.android.hazifeladat.data.repository

import hu.bme.aut.android.hazifeladat.data.entities.PizzaEntity
import kotlinx.coroutines.flow.Flow

interface PizzaPersistentRepository {
    fun getAllPizzas(): Flow<List<PizzaEntity>>

    fun getPizzaById(id: Int): Flow<PizzaEntity>

    suspend fun insertPizza(pizza: PizzaEntity)

    suspend fun updatePizza(pizza: PizzaEntity)

    suspend fun deletePizza(id: Int)

    suspend fun deletePizzas()

    suspend fun isEmpty():Boolean

}