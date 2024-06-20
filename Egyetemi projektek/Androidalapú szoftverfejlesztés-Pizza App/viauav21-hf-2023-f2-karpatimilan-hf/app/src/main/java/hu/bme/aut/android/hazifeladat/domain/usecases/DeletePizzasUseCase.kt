package hu.bme.aut.android.hazifeladat.domain.usecases

import hu.bme.aut.android.hazifeladat.data.repository.PizzaPersistentRepository

class DeletePizzasUseCase(private val repository: PizzaPersistentRepository) {

    suspend operator fun invoke() {
        repository.deletePizzas()
    }
}