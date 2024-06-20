package hu.bme.aut.android.hazifeladat.navigation

sealed class Screen(val route: String) {
    object Pizzas: Screen("pizzas")
    object Own: Screen("own")
    object Profile: Screen("profile")
    object Login: Screen("login")
    object Register: Screen("register")

    object Cart:Screen("cart")
    object Detail:Screen("detail")

}
