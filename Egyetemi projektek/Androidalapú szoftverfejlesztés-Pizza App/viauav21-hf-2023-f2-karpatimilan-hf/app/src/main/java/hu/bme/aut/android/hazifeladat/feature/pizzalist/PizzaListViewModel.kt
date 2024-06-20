package hu.bme.aut.android.hazifeladat.feature.pizzalist


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import hu.bme.aut.android.hazifeladat.PizzaApplication
import hu.bme.aut.android.hazifeladat.data.repository.MemoryPizzaRepository
import hu.bme.aut.android.hazifeladat.domain.model.Pizza
import hu.bme.aut.android.hazifeladat.domain.usecases.PizzaUseCases
import hu.bme.aut.android.hazifeladat.ui.model.PizzaUi
import hu.bme.aut.android.hazifeladat.ui.model.UiText
import hu.bme.aut.android.hazifeladat.ui.model.asPizzaUi
import hu.bme.aut.android.hazifeladat.ui.model.toUiText
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch



var empty by mutableStateOf(true)


data class PizzaCreateState(
    val pizza: PizzaUi = PizzaUi()
)
data class PizzasState(
    val Loading: Boolean = false,
    val error: Throwable? = null,
    val Error: Boolean = error != null,
    val pizzas: List<PizzaUi> = emptyList(),

)




sealed class PizzaCreateUiEvent{
    object Success : PizzaCreateUiEvent()
    data class Failure(val error: UiText) : PizzaCreateUiEvent()
}

class PizzaListViewModel constructor(
    private val cartOperations: PizzaUseCases,


) : ViewModel(){
    private val _state = MutableStateFlow(PizzasState())
    val state = _state.asStateFlow()




    init {
        loadPizzas()
    }

    private fun loadPizzas() {

        viewModelScope.launch {
            _state.update { it.copy(Loading = true) }
            try {
                val list = MemoryPizzaRepository.getAllPizzas()
                empty=cartOperations.isempty.invoke()

                    val pizzas = list.map { it.asPizzaUi() }
                    _state.update { it.copy(Loading = false, pizzas = pizzas)}

            } catch (e: Exception) {
                _state.update { it.copy(Loading = false, error = e) }
            }
        }
    }
    private val _uiEvent = Channel<PizzaCreateUiEvent>()


    fun onAdd(pizza: Pizza) {

        viewModelScope.launch {
            try {

                cartOperations.insertpizzauc(pizza)
                _uiEvent.send(PizzaCreateUiEvent.Success)
                loadPizzas()


            } catch (e: Exception) {
                _uiEvent.send(PizzaCreateUiEvent.Failure(e.toUiText()))
            }


        }

    }





    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val cartOperations=PizzaUseCases(PizzaApplication.repository)
                PizzaListViewModel(
                    cartOperations = cartOperations
                )
            }
        }
    }
}


