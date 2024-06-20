package hu.bme.aut.android.hazifeladat.data.pizzas

import hu.bme.aut.android.hazifeladat.domain.model.Points
import kotlinx.coroutines.flow.Flow

interface PizzaService {
    val points: Flow<Points?>


    suspend fun savePoints(points: Points)
    suspend fun getPoints(id:String): Points?

    suspend fun updatePoints(points: Points)

}