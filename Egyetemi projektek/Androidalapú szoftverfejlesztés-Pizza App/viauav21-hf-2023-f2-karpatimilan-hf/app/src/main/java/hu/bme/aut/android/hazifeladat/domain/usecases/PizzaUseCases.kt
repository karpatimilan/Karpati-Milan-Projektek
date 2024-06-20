package hu.bme.aut.android.hazifeladat.domain.usecases

import hu.bme.aut.android.hazifeladat.data.repository.PizzaPersistentRepository

class PizzaUseCases(repository: PizzaPersistentRepository) {
    val loadpizzauc=LoadPizzaUseCase(repository)
    val loadpizzasuc=LoadPizzasUseCase(repository)
    val deletepizzauc=DeletePizzaUseCase(repository)
    val deletepizzasuc=DeletePizzasUseCase(repository)
    val updatepizzauc=UpdatePizzaUseCase(repository)
    val insertpizzauc=InsertPizzaUseCase(repository)
    val isempty=IsEmptyUseCase(repository)
}