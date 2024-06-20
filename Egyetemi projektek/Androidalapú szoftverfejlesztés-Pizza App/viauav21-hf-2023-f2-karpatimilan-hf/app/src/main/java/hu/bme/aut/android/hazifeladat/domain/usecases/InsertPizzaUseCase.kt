package hu.bme.aut.android.hazifeladat.domain.usecases

import hu.bme.aut.android.hazifeladat.data.entities.asPizzaEntity
import hu.bme.aut.android.hazifeladat.data.repository.PizzaPersistentRepository
import hu.bme.aut.android.hazifeladat.domain.model.Pizza

class InsertPizzaUseCase(private val repository: PizzaPersistentRepository) {

    suspend operator fun invoke(pizza: Pizza) {
        repository.insertPizza(pizza.asPizzaEntity())
    }

}