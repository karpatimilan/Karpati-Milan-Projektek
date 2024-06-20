package hu.bme.aut.android.hazifeladat.domain.usecases

import hu.bme.aut.android.hazifeladat.data.repository.PizzaPersistentRepository

class DeletePizzaUseCase(private val repository:PizzaPersistentRepository) {

    suspend operator fun invoke(id: Int) {
        repository.deletePizza(id)
    }
}