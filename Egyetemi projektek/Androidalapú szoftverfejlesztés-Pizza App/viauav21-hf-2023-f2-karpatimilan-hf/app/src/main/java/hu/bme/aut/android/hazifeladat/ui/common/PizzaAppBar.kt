package hu.bme.aut.android.hazifeladat.ui.common

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.AlertDialogDefaults.titleContentColor
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import hu.bme.aut.android.hazifeladat.ui.theme.nicebrown
import hu.bme.aut.android.hazifeladat.ui.theme.niceyellow
import hu.bme.aut.android.hazifeladat.ui.theme.niceyellow2

@ExperimentalMaterial3Api
@Composable
fun PizzaAppBar(
    modifier: Modifier = Modifier,
    title: String,
    actions: @Composable() RowScope.() -> Unit,
    onNavigateBack: (() -> Unit)? = null,
    fontsize:Int=24

) {
    CenterAlignedTopAppBar(

        modifier = modifier,
        title = { Text(text = title,
            fontSize = fontsize.sp,
            fontWeight = FontWeight.ExtraBold,
            style =MaterialTheme.typography.bodyLarge,



            )
                },

        navigationIcon = {
            if (onNavigateBack != null) {
                IconButton(onClick = onNavigateBack) {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
                }
            }
        },
        actions = actions,
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = niceyellow,
            titleContentColor =Color.Black,
            actionIconContentColor = Color.Black,
            navigationIconContentColor = Color.Black,


        )

    )

}

@ExperimentalMaterial3Api
@Composable
@Preview
fun PizzaAppBar_Preview() {
    PizzaAppBar(
        title = "Pizza Title",
        actions = {},
        onNavigateBack = {}
    )
}
