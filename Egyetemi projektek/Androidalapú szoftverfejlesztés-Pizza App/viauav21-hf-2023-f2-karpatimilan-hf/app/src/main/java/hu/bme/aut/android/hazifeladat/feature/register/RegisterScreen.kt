package hu.bme.aut.android.hazifeladat.feature.register

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import hu.bme.aut.android.hazifeladat.ui.common.EmailTextField
import hu.bme.aut.android.hazifeladat.ui.common.PasswordTextField
import hu.bme.aut.android.hazifeladat.ui.common.PizzaAppBar
import hu.bme.aut.android.hazifeladat.ui.theme.niceyellow
import hu.bme.aut.android.hazifeladat.ui.theme.niceyellow2
import hu.bme.aut.android.hazifeladat.util.UiEvent
import kotlinx.coroutines.launch
import hu.bme.aut.android.hazifeladat.R.string as StringResources
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(
    onNavigateBack: () -> Unit,
    onSuccess: () -> Unit,
    viewModel: RegisterUserViewModel = viewModel(factory = RegisterUserViewModel.Factory)
) {

    val state by viewModel.state.collectAsStateWithLifecycle()

    val snackbarHostState = SnackbarHostState()

    val scope = rememberCoroutineScope()

    val context = LocalContext.current

    LaunchedEffect(key1 = true) {
        viewModel.uiEvent.collect { event ->
            when(event) {
                is UiEvent.Success -> {
                    onSuccess()
                }
                is UiEvent.Failure -> {
                    scope.launch {
                        snackbarHostState.showSnackbar(
                            message = event.message.asString(context)
                        )
                    }
                }
            }
        }
    }

    Scaffold(
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) },
        topBar = {
            PizzaAppBar(
                title = stringResource(id =StringResources.app_bar_title_sign_up),
                actions = {  },
                onNavigateBack = onNavigateBack
            )
        },
        modifier = Modifier.fillMaxSize()
            .background(niceyellow),
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .background(niceyellow)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            EmailTextField(
                value = state.email,
                label = stringResource(id = StringResources.textfield_label_email),
                onValueChange = { viewModel.onEvent(RegisterUserEvent.EmailChanged(it)) },
                onDone = {},
                imeAction = ImeAction.Next,
                modifier = Modifier.padding(bottom = 10.dp)
            )
            PasswordTextField(
                value = state.password,
                label = stringResource(id = StringResources.textfield_label_password),
                onValueChange = { viewModel.onEvent(RegisterUserEvent.PasswordChanged(it)) },
                onDone = {},
                imeAction = ImeAction.Next,
                modifier = Modifier.padding(bottom = 10.dp),
                isVisible = state.passwordVisibility,
                onVisibilityChanged = { viewModel.onEvent(RegisterUserEvent.PasswordVisibilityChanged) }
            )
            PasswordTextField(
                value = state.confirmPassword,
                label = stringResource(id = StringResources.textfield_label_confirm_password),
                onValueChange = { viewModel.onEvent(RegisterUserEvent.ConfirmPasswordChanged(it)) },
                onDone = {},
                modifier = Modifier.padding(bottom = 10.dp),
                isVisible = state.confirmPasswordVisibility,
                onVisibilityChanged = { viewModel.onEvent(RegisterUserEvent.ConfirmPasswordVisibilityChanged) }
            )
            Button(
                colors = ButtonDefaults.buttonColors(Color.White, Color.Black),
                onClick = { viewModel.onEvent(RegisterUserEvent.SignUp) }) {
                Text(

                    text = stringResource(id = StringResources.button_text_sign_up)
                    )

            }
            Spacer(modifier=Modifier.height(80.dp))
        }
    }
}