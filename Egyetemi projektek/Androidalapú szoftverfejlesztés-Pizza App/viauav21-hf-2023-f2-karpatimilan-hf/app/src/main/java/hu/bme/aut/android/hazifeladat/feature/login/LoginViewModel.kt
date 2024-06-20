package hu.bme.aut.android.hazifeladat.feature.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import hu.bme.aut.android.hazifeladat.PizzaApplication
import hu.bme.aut.android.hazifeladat.R

import hu.bme.aut.android.hazifeladat.data.auth.AuthService
import hu.bme.aut.android.hazifeladat.domain.usecases.IsEmailValidUseCase
import hu.bme.aut.android.hazifeladat.ui.model.UiText
import hu.bme.aut.android.hazifeladat.ui.model.toUiText
import hu.bme.aut.android.hazifeladat.util.UiEvent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LoginUserViewModel constructor(
    private val authService: AuthService,
    private val isEmailValid: IsEmailValidUseCase,
): ViewModel() {

    private val _state = MutableStateFlow(LoginUserState())
    val state = _state.asStateFlow()

    private val email get() = state.value.email

    private val password get() = state.value.password

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    fun onEvent(event: LoginUserEvent) {
        when(event) {
            is LoginUserEvent.EmailChanged -> {
                val newEmail = event.email.trim()
                _state.update { it.copy(email = newEmail) }
            }
            is LoginUserEvent.PasswordChanged -> {
                val newPassword = event.password.trim()
                _state.update { it.copy(password = newPassword) }
            }
            LoginUserEvent.PasswordVisibilityChanged -> {
                _state.update { it.copy(passwordVisibility = !state.value.passwordVisibility) }
            }
            LoginUserEvent.SignIn -> {
                onSignIn()
            }
        }
    }

    private fun onSignIn() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                if (!isEmailValid(email)) {
                    _uiEvent.send(
                        UiEvent.Failure(UiText.StringResource(R.string.some_error_message))
                    )
                } else {
                    if (password.isBlank()) {
                        _uiEvent.send(
                            UiEvent.Failure(UiText.StringResource(R.string.some_error_message))
                        )
                    } else {
                        authService.authenticate(email,password)
                        _uiEvent.send(UiEvent.Success)
                    }
                }
            } catch (e: Exception) {
                _uiEvent.send(UiEvent.Failure(e.toUiText()))
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val authService = PizzaApplication.authService
                val isEmailValidUseCase = IsEmailValidUseCase()
                LoginUserViewModel(
                    authService,
                    isEmailValidUseCase
                )
            }
        }
    }
}


data class LoginUserState(
    val email: String = "",
    val password: String = "",
    val passwordVisibility: Boolean = false
)

sealed class LoginUserEvent {
    data class EmailChanged(val email: String): LoginUserEvent()
    data class PasswordChanged(val password: String): LoginUserEvent()
    object PasswordVisibilityChanged: LoginUserEvent()
    object SignIn: LoginUserEvent()
}