package hu.bme.aut.android.hazifeladat.feature.cart


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import hu.bme.aut.android.hazifeladat.R
import hu.bme.aut.android.hazifeladat.feature.pizzalist.empty
import hu.bme.aut.android.hazifeladat.ui.common.CustomDialog
import hu.bme.aut.android.hazifeladat.ui.common.PizzaAppBar
import hu.bme.aut.android.hazifeladat.ui.model.asPizza
import hu.bme.aut.android.hazifeladat.ui.model.toUiText
import hu.bme.aut.android.hazifeladat.ui.theme.niceyellow


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CartScreen(
    onNavigateBack: () -> Unit,
    onNavigateProfile:()->Unit,
    viewModel: CartViewModel = viewModel(factory = CartViewModel.Factory),
) {
    val state = viewModel.state.collectAsStateWithLifecycle().value
    val context = LocalContext.current

    val lifecycleOwner = LocalLifecycleOwner.current
    DisposableEffect(lifecycleOwner) {
        val observer = LifecycleEventObserver { _, event ->
            if (event == Lifecycle.Event.ON_RESUME) {
                viewModel.loadPizzas()
            }
        }
        lifecycleOwner.lifecycle.addObserver(observer)
        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)
        }
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),

        topBar = {
            PizzaAppBar(
                title = stringResource(id = R.string.app_bar_title_cart
                ),
                fontsize = 28,
                onNavigateBack = {
                    onNavigateBack()
                    empty = true
                },
                actions = {
                    IconButton(onClick = { viewModel.onDeleteAll() }) {
                        Icon(
                            imageVector = Icons.Filled.Delete,
                            contentDescription = null,
                            modifier = Modifier.size(30.dp)
                        )

                    }
                },

                )

        },
        bottomBar = {

            when (state) {
                is CartListState.Error -> Text(text = "")
                is CartListState.Loading -> Text(text = "")
                is CartListState.Result -> {

                    Button(
                        onClick = {viewModel.onPay()


                                  },
                        colors = ButtonDefaults.buttonColors(niceyellow, Color.Black),
                        shape = RectangleShape,
                        modifier = Modifier.padding(horizontal = 20.dp, vertical = 15.dp)
                                            .clip(RoundedCornerShape(30.dp))

                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween

                        ) {
                            Text(
                                text = stringResource(id = R.string.button_text_pay),
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold

                            )
                            Text(
                                state.totalSum.toString() + "Ft",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.ExtraBold
                            )
                        }

                    }
                }
            }

        }

    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .background(
                    color = Color.White

                ),
            contentAlignment = Alignment.Center
        ) {
            when (state) {
                is CartListState.Loading -> CircularProgressIndicator(
                    color = MaterialTheme.colorScheme.secondaryContainer
                )

                is CartListState.Error -> Text(
                    text = state.error.toUiText().asString(context)
                )

                is CartListState.Result -> {
                    if (state.CartList.isEmpty()) {
                        Text(text = stringResource(id = R.string.text_empty_cart))
                    } else {
                        LazyColumn(
                            modifier = Modifier
                                .fillMaxSize()
                        ) {
                            items(state.CartList, key = { pizza -> pizza.id }) { pizza ->
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(8.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {

                                    // Spacer for separation
                                    Spacer(modifier = Modifier.width(8.dp))
                                    Row(

                                    ) {
                                        Column(Modifier.width(width = 300.dp)) {
                                            Text(
                                                text = pizza.name,
                                                fontSize = 25.sp,
                                                fontWeight = FontWeight.Bold
                                            )
                                            Text(
                                                text = pizza.price.toString() + "Ft",
                                                fontSize = 15.sp,
                                                modifier = Modifier.padding(top = 5.dp, start = 5.dp)
                                            )
                                        }

                                            Button(
                                                colors = ButtonDefaults.buttonColors(
                                                    niceyellow,
                                                    Color.Black
                                                ),
                                                onClick = { viewModel.onDelete(pizza.asPizza()) },
                                                modifier = Modifier
                                                    .padding(
                                                        end = 5.dp,
                                                        top = 9.dp,
                                                        start = 7.dp
                                                    )
                                                    .size(height = 30.dp, width = 60.dp)
                                                    .clip(RoundedCornerShape(20.dp))
                                                ,

                                                shape = RectangleShape,
                                                contentPadding = PaddingValues(0.dp)
                                            ) {
                                                Icon(
                                                    imageVector = Icons.Default.Delete,
                                                    contentDescription = null
                                                )

                                            }


                                    }
                                }
                                if(viewModel.isDialogShown){
                              CustomDialog(
                                  onDismiss = { viewModel.onDismiss() },
                                  onConfirm = { viewModel.onConfirm()
                                      onNavigateProfile()},
                                  osszeg = state.totalSum,
                              )
                                }
                                Divider(
                                    thickness = 2.dp,
                                    color = Color.Gray
                                )
                            }


                        }
                    }
                }
            }


        }


    }
}


