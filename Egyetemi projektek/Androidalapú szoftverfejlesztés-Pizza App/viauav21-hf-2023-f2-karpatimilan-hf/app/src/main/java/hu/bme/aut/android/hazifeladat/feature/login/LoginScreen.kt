package hu.bme.aut.android.hazifeladat.feature.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import hu.bme.aut.android.hazifeladat.ui.common.EmailTextField
import hu.bme.aut.android.hazifeladat.ui.common.PasswordTextField
import hu.bme.aut.android.hazifeladat.ui.theme.niceyellow
import hu.bme.aut.android.hazifeladat.util.UiEvent
import kotlinx.coroutines.launch
import hu.bme.aut.android.hazifeladat.R.string as StringResources

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    onSuccess: () -> Unit,
    onRegisterClick: () -> Unit,
    viewModel: LoginUserViewModel = viewModel(factory = LoginUserViewModel.Factory)
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
        modifier = Modifier.fillMaxSize()
            .background(niceyellow),


                bottomBar = {

                    Button(
                        colors = ButtonDefaults.buttonColors(Color.White, Color.Black),
                        onClick = onRegisterClick,
                        modifier = Modifier
                            .padding(bottom = 1.dp, start = 3.dp, end = 3.dp)
                            .fillMaxWidth(),


                    ) {
                        Text(text = stringResource(id = StringResources.button_text_no_account))
                    }


                }


    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .background(niceyellow)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(110.dp))
            Text(

                "Pizzi",
                fontSize = 80.sp,
                fontWeight = FontWeight.ExtraBold,
                style =MaterialTheme.typography.titleLarge,
                fontStyle = FontStyle.Italic,
            )
            Spacer(modifier = Modifier.height(120.dp))
            EmailTextField(
                value = state.email,
                label = stringResource(id = StringResources.textfield_label_email),
                onValueChange = { viewModel.onEvent(LoginUserEvent.EmailChanged(it)) },
                onDone = {},
                imeAction = ImeAction.Next,
                modifier = Modifier.padding(bottom = 10.dp)
            )
            PasswordTextField(
                value = state.password,
                label = stringResource(id = StringResources.textfield_label_password),
                onValueChange = { viewModel.onEvent(LoginUserEvent.PasswordChanged(it)) },
                onDone = {},
                modifier = Modifier.padding(bottom = 10.dp),
                isVisible = state.passwordVisibility,
                onVisibilityChanged = { viewModel.onEvent(LoginUserEvent.PasswordVisibilityChanged) }
            )
            Button(
                colors = ButtonDefaults.buttonColors(Color.White, Color.Black),
                onClick = { viewModel.onEvent(LoginUserEvent.SignIn) },
                modifier = Modifier.padding(bottom = 10.dp)
                    .size(280.dp,40.dp)
            ) {
                Text(text = stringResource(id = StringResources.button_text_sign_in))
            }

            }

    }
}