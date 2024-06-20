package hu.bme.aut.android.hazifeladat.navigation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import hu.bme.aut.android.hazifeladat.feature.cart.CartScreen

import hu.bme.aut.android.hazifeladat.feature.login.LoginScreen
import hu.bme.aut.android.hazifeladat.feature.mypizza.MyPizzaScreen
import hu.bme.aut.android.hazifeladat.feature.pizzalist.PizzaListScreen
import hu.bme.aut.android.hazifeladat.feature.profile.ProfileScreen
import hu.bme.aut.android.hazifeladat.feature.register.RegisterScreen



@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun NavGraph(
    navController: NavHostController = rememberNavController(),
) {

    NavHost(
        navController = navController,
        startDestination = Screen.Login.route
    ) {
        composable(Screen.Login.route) {
            LoginScreen(
                onSuccess = {
                    navController.navigate(Screen.Pizzas.route)
                },
                onRegisterClick = {
                    navController.navigate(Screen.Register.route)
                }
            )
        }
        composable(Screen.Register.route) {
            RegisterScreen(
                onNavigateBack = {
                    navController.popBackStack(
                        route = Screen.Login.route,
                        inclusive = true
                    )
                    navController.navigate(Screen.Login.route)
                },
                onSuccess = {
                    navController.navigate(Screen.Pizzas.route)
                }
            )
        }
        composable(Screen.Pizzas.route) {
            val backStackEntry = navController.currentBackStackEntryAsState()
            backStackEntry.value?.destination?.route?.let { it1 ->
                PizzaListScreen(
                    onBottomClick = {
                        navController.navigate(it)
                    },
                    actualroute = it1,

                    onNavigateCart={navController.navigate(Screen.Cart.route)}
                )
            }


        }
        composable(Screen.Profile.route) {
            val backStackEntry = navController.currentBackStackEntryAsState()
            backStackEntry.value?.destination?.route?.let { it2 ->
                ProfileScreen(
                    onBottomClick = {
                        navController.navigate(it)
                    },
                    actualroute = it2,
                    onNavigateSignIn={navController.navigate(Screen.Login.route)}
                )
            }
        }
                composable(Screen.Own.route) {
                    val backStackEntry = navController.currentBackStackEntryAsState()
                    backStackEntry.value?.destination?.route?.let { it3 ->
                        MyPizzaScreen(
                            onBottomClick = {
                                navController.navigate(it)
                            },
                            actualroute = it3

                        )

                    }
                }
        composable(Screen.Cart.route) {
                CartScreen(
                  onNavigateBack = {
                      navController.popBackStack(
                          route = Screen.Pizzas.route,
                          inclusive = false)

                  },
                    onNavigateProfile={
                        navController.navigate(Screen.Profile.route)

                    }

                )

            }
        }
            }


