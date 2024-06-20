package hu.bme.aut.android.hazifeladat.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import hu.bme.aut.android.hazifeladat.R


val rosewood1= FontFamily(
    listOf(
        Font(R.font.rosewood, FontWeight.Normal),
    )
)
val helvectica=FontFamily(
    listOf(
        Font(R.font.helvectica,FontWeight.Normal),
        Font(R.font.helvecticabrr,FontWeight.Bold),


    )



)

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = helvectica,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),

    titleLarge = TextStyle(
        fontFamily = rosewood1,
        fontWeight = FontWeight.Bold,
        fontSize = 22.sp,
        color = Color.Black,

    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )

)