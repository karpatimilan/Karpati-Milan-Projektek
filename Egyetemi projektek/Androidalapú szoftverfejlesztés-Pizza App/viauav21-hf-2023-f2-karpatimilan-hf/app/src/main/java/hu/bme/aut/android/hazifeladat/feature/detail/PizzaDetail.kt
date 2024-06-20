package hu.bme.aut.android.hazifeladat.feature.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import hu.bme.aut.android.hazifeladat.data.repository.MemoryPizzaRepository
import hu.bme.aut.android.hazifeladat.data.repository.PizzaRepository
import hu.bme.aut.android.hazifeladat.ui.model.PizzaUi
import hu.bme.aut.android.hazifeladat.ui.model.asPizzaUi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.delay
sealed class PizzaDetailState {
    object Loading : PizzaDetailState()
    data class Error(val error: Throwable) : PizzaDetailState()
    data class Result(val pizza: PizzaUi) : PizzaDetailState()
}

class PizzaDetailViewModel(private val repository: PizzaRepository, private val savedStateHandle: SavedStateHandle) : ViewModel() {

    private val _state = MutableStateFlow<PizzaDetailState>(PizzaDetailState.Loading)
    val state = _state.asStateFlow()

    init {
        loadPizzas()
    }

    private fun loadPizzas() {
        val id = checkNotNull<Int>(savedStateHandle["id"])
        viewModelScope.launch {
            try {
                _state.value = PizzaDetailState.Loading
                delay(2000)
                val pizza = repository.getPizzaById(id)
                _state.value = PizzaDetailState.Result(
                    pizza.asPizzaUi()
                )
            } catch (e: Exception) {
                _state.value = PizzaDetailState.Error(e)
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val savedStateHandle = createSavedStateHandle()
                PizzaDetailViewModel(
                    MemoryPizzaRepository,
                    savedStateHandle
                )
            }
        }
    }
}