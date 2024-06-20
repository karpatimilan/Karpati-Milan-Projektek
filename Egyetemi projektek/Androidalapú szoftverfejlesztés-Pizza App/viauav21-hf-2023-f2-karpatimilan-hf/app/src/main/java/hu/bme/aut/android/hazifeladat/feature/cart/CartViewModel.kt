package hu.bme.aut.android.hazifeladat.feature.cart

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import hu.bme.aut.android.hazifeladat.PizzaApplication
import hu.bme.aut.android.hazifeladat.data.pizzas.PizzaService
import hu.bme.aut.android.hazifeladat.domain.model.Pizza
import hu.bme.aut.android.hazifeladat.domain.model.Points
import hu.bme.aut.android.hazifeladat.domain.usecases.PizzaUseCases
import hu.bme.aut.android.hazifeladat.ui.model.PizzaUi
import hu.bme.aut.android.hazifeladat.ui.model.asPizzaUi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

sealed class CartListState {
    object Loading : CartListState()
    data class Error(val error: Throwable) : CartListState()
    data class Result(val CartList : List<PizzaUi>,val totalSum:Int) : CartListState()
}

class CartViewModel(
    private val cartOperations: PizzaUseCases,
    private val pointsService: PizzaService
) : ViewModel() {

    private val _state = MutableStateFlow<CartListState>(CartListState.Loading)
    val state = _state.asStateFlow()

    var isDialogShown by mutableStateOf(false)
        private set


    fun loadPizzas() {
        viewModelScope.launch {
            try {
                _state.value = CartListState.Loading
                val pizzas = cartOperations.loadpizzasuc().getOrThrow().map { it.asPizzaUi() }
                val price=cartOperations.loadpizzasuc().getOrThrow().map { it.price }.sum()
                _state.value = CartListState.Result(
                    CartList = pizzas,
                    totalSum = price
                )
            } catch (e: Exception) {
                _state.value = CartListState.Error(e)
            }
        }
    }
    fun onDeleteAll() {
        viewModelScope.launch {
            cartOperations.deletepizzasuc();
            loadPizzas();

        }
    }
    fun onDelete(pizza: Pizza) {
        viewModelScope.launch {
            cartOperations.deletepizzauc(pizza.id);
            loadPizzas();

        }
    }

    fun onDismiss(){
        isDialogShown=false
    }
    fun onPay(){
        viewModelScope.launch {
            if(pointsService.getPoints("user_points")==null){
                pointsService.savePoints(Points("user_points",0))
            }
        }
        isDialogShown=true
    }
    fun onConfirm(){
        isDialogShown=false
        viewModelScope.launch {
            val points = pointsService.getPoints("user_points")
            var sum= (points?.points ?:0) +(cartOperations.loadpizzasuc().getOrThrow().map { it.price }.sum())
            pointsService.updatePoints(Points("user_points",sum))
        }
        onDeleteAll()

    }


    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val cartOperations = PizzaUseCases(PizzaApplication.repository)
                val pointsService=PizzaApplication.pointsService
                CartViewModel(
                    cartOperations,
                    pointsService
                )
            }
        }
    }
}