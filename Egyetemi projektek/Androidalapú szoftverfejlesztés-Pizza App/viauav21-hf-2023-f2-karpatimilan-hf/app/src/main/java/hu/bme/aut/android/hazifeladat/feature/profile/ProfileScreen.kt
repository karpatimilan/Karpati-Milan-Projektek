@file:Suppress("KotlinConstantConditions")

package hu.bme.aut.android.hazifeladat.feature.profile

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Logout
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingBag
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import hu.bme.aut.android.hazifeladat.ui.common.PizzaAppBar
import hu.bme.aut.android.hazifeladat.ui.common.navbar.BottomNavigationBar
import hu.bme.aut.android.hazifeladat.ui.common.navbar.NavigationBarItem
import hu.bme.aut.android.hazifeladat.ui.common.points.Pointbar
import hu.bme.aut.android.hazifeladat.ui.theme.nicebrown
import hu.bme.aut.android.hazifeladat.ui.theme.nicered
import hu.bme.aut.android.hazifeladat.ui.theme.niceyellow
import hu.bme.aut.android.hazifeladat.ui.theme.nicgrey


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(
    onBottomClick: (String) -> Unit,
    actualroute: String,
    viewModel: ProfileViewModel = viewModel(factory =ProfileViewModel.Factory),
    onNavigateSignIn:()->Unit,
) {


    val state = viewModel.state.collectAsStateWithLifecycle().value
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current
    DisposableEffect(lifecycleOwner) {
        val observer = LifecycleEventObserver { _, event ->
            if (event == Lifecycle.Event.ON_RESUME) {
                viewModel.loadPoints()
            }
        }
        lifecycleOwner.lifecycle.addObserver(observer)
        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)
        }
    }


    Scaffold(
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

        },
        topBar = {
            PizzaAppBar(title = "Profil", actions = {
                IconButton(onClick = { viewModel.onSignOut()
                    onNavigateSignIn()}) {
                Icon(
                    imageVector = Icons.Filled.Logout,
                    contentDescription = null,
                    modifier = Modifier.size(30.dp)
                )

            }

                                                    }, fontsize = 40)
        }
    ) {
Box(
    contentAlignment = Alignment.TopCenter,
    modifier = Modifier
        .fillMaxSize()
        .padding(it)
        .background(
            color = nicgrey
        ),
){
  Column(horizontalAlignment = Alignment.CenterHorizontally) {


      Spacer(modifier = Modifier.height(30.dp))
      when (state) {
          is PointListState.Error -> Text(text = "")
          is PointListState.Loading -> Text(text = "")
          is PointListState.Result -> {
      Box(modifier =
      Modifier
          .fillMaxWidth()
          .height(290.dp)
          .padding(horizontal = 10.dp)
          .background(color = Color.Transparent)
          .clip(RoundedCornerShape(10.dp)),
            contentAlignment = Alignment.Center
      ) {
          Surface(
              modifier = Modifier
                  .fillMaxSize()
                  .clip(RoundedCornerShape(20.dp))
                  .background(nicebrown),
              color = nicebrown

          )


          {
              Column(
                  horizontalAlignment = Alignment.CenterHorizontally

              ) {

                  Text(
                      text = "Rendelj 20 000 Ft értékben és nyerj egy ingyen pizzát!",
                      fontSize = 22.sp,
                      fontWeight = FontWeight.ExtraBold,
                      style = MaterialTheme.typography.bodyLarge,
                      color = Color.White,
                      modifier = Modifier.padding(20.dp)
                  )
                  Pointbar(
                      percentage = state.points,
                      number = 100,
                  )


              }

          }
          Column(
              modifier = Modifier.fillMaxSize(),
              verticalArrangement = Arrangement.SpaceEvenly,

          ) {
              Box(
                  modifier = Modifier
                      .height(200.dp)
                      .fillMaxWidth()
                      .background(color = Color.Transparent)

              )
              if(state.koltes>0) {
                  Box(
                      modifier = Modifier
                          .fillMaxWidth()
                          .height(30.dp)
                          .padding(horizontal = 10.dp)
                          .background(color = Color.Transparent)
                          .clip(RoundedCornerShape(10.dp))
                  ) {
                      Surface(
                          modifier = Modifier
                              .fillMaxSize()
                              .height(40.dp)
                              .clip(RoundedCornerShape(10.dp))
                              .background(niceyellow),
                          color = niceyellow
                      ) {
                          Row(modifier = Modifier.fillMaxWidth()) {
                              Text(
                                  text = "Már csak",
                                  fontSize = 14.sp,
                                  style = MaterialTheme.typography.bodyLarge,
                                  color = nicebrown,
                                  modifier = Modifier.padding(top = 5.dp, end = 2.dp, start = 2.dp)
                              )
                              Text(
                                  text = state.koltes.toString(),
                                  color = nicered,
                                  modifier = Modifier.padding(start = 2.dp, end = 2.dp, top = 4.dp)
                              )
                              Text(
                                  text = "-Ft-ra vagy az ingyen pizzától!",
                                  fontSize = 14.sp,
                                  style = MaterialTheme.typography.bodyLarge,
                                  color = nicebrown,
                                  modifier = Modifier.padding(top = 5.dp)
                              )

                          }
                      }
                  }
              }


              }
          }
              if(state.koltes<0) {
                  Box(
                      modifier = Modifier
                          .fillMaxWidth()
                          .height(30.dp)
                          .padding(horizontal = 12.dp)
                          .background(color = Color.Transparent)
                          .clip(RoundedCornerShape(10.dp))

                  )
                  Box(
                      modifier = Modifier.fillMaxWidth()

                  ) {
                      Button(
                          onClick = { viewModel.onRedeem()},
                          modifier = Modifier.fillMaxWidth()
                              .padding(horizontal = 10.dp),
                          colors = ButtonDefaults.buttonColors(
                              containerColor = niceyellow,
                              contentColor = Color.Black

                          )
                      ) {
                          Text(text = "Ajándék pizza beváltása",
                              fontSize = 20.sp,
                              style=MaterialTheme.typography.bodyLarge

                          )

                      }
                  }
              }
              }
      }

}



  }
 }

    }

