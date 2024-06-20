package hu.bme.aut.android.hazifeladat.feature.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import hu.bme.aut.android.hazifeladat.PizzaApplication
import hu.bme.aut.android.hazifeladat.data.auth.AuthService
import hu.bme.aut.android.hazifeladat.data.pizzas.PizzaService
import hu.bme.aut.android.hazifeladat.domain.model.Points
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


sealed class PointListState {
    object Loading : PointListState()
    data class Error(val error: Throwable) : PointListState()
    data class Result(val points : Float,val koltes:Int) : PointListState()
}

class ProfileViewModel(
    private val pointsService: PizzaService,
    private val authService: AuthService
) : ViewModel() {

    private val _state = MutableStateFlow<PointListState>(PointListState.Loading)
    val state = _state.asStateFlow()




    fun loadPoints() {
        viewModelScope.launch {
            try {
                _state.value = PointListState.Loading
                if(pointsService.getPoints("user_points")==null){
                    pointsService.savePoints(Points("user_points",0))
                }
                val point= pointsService.getPoints("user_points")?.points
                var percentage= point?.toFloat()?.div(20000)
                if(percentage!! >1){percentage=1f}
                val hatra=20000- point!!
                _state.value = PointListState.Result(
                   points= percentage!!,
                    koltes = hatra
                    )
            } catch (e: Exception) {
                _state.value = PointListState.Error(e)
            }
        }
    }

   fun onRedeem(){
       viewModelScope.launch {
           val points= pointsService.getPoints("user_points")?.points
           pointsService.updatePoints(Points("user_points",points!!-20000))
           loadPoints()
       }
    }

    fun onSignOut(){
        viewModelScope.launch {
            authService.signOut()
        }
    }






    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val pointsService= PizzaApplication.pointsService
                val authService = PizzaApplication.authService
                ProfileViewModel(
                    pointsService,
                    authService
                )
            }
        }
    }
}