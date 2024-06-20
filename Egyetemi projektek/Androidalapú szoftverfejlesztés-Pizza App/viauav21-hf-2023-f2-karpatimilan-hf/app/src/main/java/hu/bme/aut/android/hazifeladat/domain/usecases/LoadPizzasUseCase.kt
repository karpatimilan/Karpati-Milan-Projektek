package hu.bme.aut.android.hazifeladat.domain.usecases

import hu.bme.aut.android.hazifeladat.data.entities.asPizza
import hu.bme.aut.android.hazifeladat.data.repository.PizzaPersistentRepository
import hu.bme.aut.android.hazifeladat.domain.model.Pizza
import kotlinx.coroutines.flow.first
import java.io.IOException

class LoadPizzasUseCase(private val repository: PizzaPersistentRepository) {
    suspend operator fun invoke(): Result<List<Pizza>> {
        return try {
            val pizzas = repository.getAllPizzas().first()
            Result.success(pizzas.map { it.asPizza() })
        } catch (e: IOException) {
            Result.failure(e)
        }
    }
}