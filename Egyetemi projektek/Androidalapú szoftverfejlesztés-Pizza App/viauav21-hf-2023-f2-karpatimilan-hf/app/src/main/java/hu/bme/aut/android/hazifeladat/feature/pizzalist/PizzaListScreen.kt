package hu.bme.aut.android.hazifeladat.feature.pizzalist

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingBag
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import hu.bme.aut.android.hazifeladat.R
import hu.bme.aut.android.hazifeladat.ui.common.navbar.BottomNavigationBar
import hu.bme.aut.android.hazifeladat.ui.common.navbar.NavigationBarItem
import hu.bme.aut.android.hazifeladat.ui.model.asPizza
import hu.bme.aut.android.hazifeladat.ui.model.toUiText
import hu.bme.aut.android.hazifeladat.ui.theme.niceyellow
import hu.bme.aut.android.hazifeladat.ui.theme.nicgrey


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PizzaListScreen(
    onBottomClick: (String) -> Unit,
    viewModel: PizzaListViewModel = viewModel(factory = PizzaListViewModel.Factory),
    actualroute: String,
    onNavigateCart: () -> Unit,

) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    val context = LocalContext.current


    Scaffold(
        modifier = Modifier.fillMaxSize(),
            topBar = {
                CenterAlignedTopAppBar(


                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor =  niceyellow,
                        titleContentColor =Color.Black,

                    ),

                    title = {

                        Text(
                            "Pizzi",
                            fontSize = 50.sp,
                            fontWeight = FontWeight.ExtraBold,
                            style =MaterialTheme.typography.titleLarge,
                            fontStyle = FontStyle.Italic,
                        )
                    },

                    actions = {

                           if (false) {
                               BadgedBox(
                                   badge = { Badge() },
                                   modifier = Modifier.padding(end = 5.dp)
                               ) {
                                   IconButton(onClick = onNavigateCart) {
                                       Icon(
                                           imageVector = Icons.Filled.ShoppingCart,
                                           contentDescription = null,
                                       )
                                   }
                               }
                           } else {
                               IconButton(onClick = onNavigateCart) {
                                   Icon(
                                       imageVector = Icons.Filled.ShoppingCart,
                                       contentDescription = null,
                                       modifier = Modifier.padding(end = 5.dp)
                                   )
                               }
                           }

                        }



                )
            },
        bottomBar = {
            BottomNavigationBar(
                items = listOf(
                NavigationBarItem(
                    name = "Rendelés",
                    route = "pizzas",
                    icon = Icons.Default.ShoppingBag,
                    badgeCount = 0
                ),

                NavigationBarItem(
                    name = "Profile",
                    route = "profile",
                    icon = Icons.Default.Person,
                    badgeCount = 0
                ),
                ),
                actualroute=actualroute,
                onItemClick = { onBottomClick(it.route)
                })
            
        }


    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .background(
                    color = nicgrey
                ),
            contentAlignment = Alignment.Center
        ) {
            if (state.Loading) {
                CircularProgressIndicator(
                    color = MaterialTheme.colorScheme.secondaryContainer
                )
            } else if (state.Error) {
                Text(
                    text = state.error?.toUiText()?.asString(context)
                        ?: stringResource(id = R.string.some_error_message)
                )

                } else {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {

                            LazyColumn(
                                modifier = Modifier
                                    .fillMaxSize()
                            ) {
                                items(9) {i ->
                                    Row(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(8.dp),
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {

                                        Image(
                                            painter = painterResource(id = state.pizzas[i].imageResId),
                                            contentDescription = null,
                                            contentScale = ContentScale.Crop,
                                            alignment = Alignment.Center,

                                            modifier = Modifier
                                                .size(100.dp) // Adjust the size as needed
                                                .clip(RoundedCornerShape(10.dp))


                                        )

                                        // Spacer for separation
                                        Spacer(modifier = Modifier.width(8.dp))

                                        Column() {
                                            Text(
                                            text = state.pizzas[i].name,
                                            fontSize = 25.sp,
                                            fontWeight = FontWeight.Bold
                                        )
                                            Text(
                                                text = state.pizzas[i].toppings,
                                                fontSize = 15.sp,
                                                modifier=Modifier.padding(start = 8.dp),


                                            )


                                            Row(horizontalArrangement = Arrangement.End,
                                                modifier = Modifier.fillMaxWidth()
                                            ) {
                                                Text(
                                                    text = state.pizzas[i].price.toString() + "Ft",
                                                    fontSize = 15.sp,
                                                    modifier=Modifier.padding(top = 15.dp)
                                                )
                                                Button(
                                                    colors = ButtonDefaults.buttonColors(niceyellow, Color.Black),
                                                    onClick = {viewModel.onAdd(state.pizzas[i].asPizza())
                                                              },
                                                    modifier = Modifier
                                                        .padding(
                                                            end = 5.dp,
                                                            top = 9.dp,
                                                            start = 7.dp
                                                        )
                                                        .size(height = 30.dp, width = 100.dp)
                                                        .clip(RoundedCornerShape(20.dp)),
                                                    shape = RectangleShape
                                                ){

                                                    Text(text = stringResource(id = R.string.button_text_to_cart),
                                                        modifier=Modifier.padding(horizontal = 0.dp, vertical = 0.dp),
                                                        fontSize = 12.sp



                                                    )
                                                }
                                            }
                                        }



                                    }


                                    if (i != state.pizzas.lastIndex) {
                                        Divider(
                                            thickness = 2.dp,
                                            color =Color.Gray
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }


