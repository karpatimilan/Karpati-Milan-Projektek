package hu.bme.aut.android.hazifeladat.domain.usecases

import hu.bme.aut.android.hazifeladat.data.entities.asPizza
import hu.bme.aut.android.hazifeladat.data.repository.PizzaPersistentRepository
import hu.bme.aut.android.hazifeladat.domain.model.Pizza
import kotlinx.coroutines.flow.first
import java.io.IOException

class LoadPizzaUseCase(private val repository: PizzaPersistentRepository) {

    suspend operator fun invoke(id: Int): Result<Pizza> {
        return try {
            Result.success(repository.getPizzaById(id).first().asPizza())
        } catch (e: IOException) {
            Result.failure(e)
        }
    }
}