package hu.bme.aut.android.hazifeladat

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import hu.bme.aut.android.hazifeladat.navigation.NavGraph
import hu.bme.aut.android.hazifeladat.ui.theme.PizzaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PizzaTheme {
                NavGraph()
            }
        }
    }
}