package hu.bme.aut.android.hazifeladat.domain.usecases


import hu.bme.aut.android.hazifeladat.data.repository.PizzaPersistentRepository
import java.io.IOException


class IsEmptyUseCase(private val repository: PizzaPersistentRepository) {
    suspend operator fun invoke(): Boolean {
  return repository.isEmpty()
    }
}
