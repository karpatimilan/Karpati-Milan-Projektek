package hu.bme.aut.android.hazifeladat.feature.mypizza

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocalPizza
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingBag
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import hu.bme.aut.android.hazifeladat.feature.login.LoginUserViewModel
import hu.bme.aut.android.hazifeladat.ui.common.navbar.BottomNavigationBar
import hu.bme.aut.android.hazifeladat.ui.common.navbar.NavigationBarItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyPizzaScreen(
    onBottomClick: (String) -> Unit,
    actualroute: String
) {
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
                        name = "My Pizza",
                        route = "own",
                        icon = Icons.Default.LocalPizza,
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
    ) {}





}







