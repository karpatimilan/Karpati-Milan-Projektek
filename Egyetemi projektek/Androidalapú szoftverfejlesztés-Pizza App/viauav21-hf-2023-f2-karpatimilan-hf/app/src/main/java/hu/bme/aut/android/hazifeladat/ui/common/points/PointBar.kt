package hu.bme.aut.android.hazifeladat.ui.common.points

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.Stroke

import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import hu.bme.aut.android.hazifeladat.ui.theme.nicebrown
import hu.bme.aut.android.hazifeladat.ui.theme.niceyellow

@Composable
fun Pointbar(
    percentage:Float,
    number:Int,
    fontSize: TextUnit =38.sp,
    radius: Dp =100.dp,
    color: Color = niceyellow,
    strokeWidth:Dp=26.dp,
    animationDuration:Int=2000,
    animationDelay:Int=100
){
    var animationPlayed by remember{
        mutableStateOf(false)
    }
    val currentpercentage= animateFloatAsState(
        targetValue = if(animationPlayed)percentage else 0f,
        animationSpec = tween(
           durationMillis = animationDuration,
            delayMillis = animationDelay
        )
    )
LaunchedEffect(true){
animationPlayed=true
}
Box(
    contentAlignment = Alignment.Center,
    modifier = Modifier.size(radius*2f)
    ) {
    Canvas(modifier=Modifier.size(radius*2f-(strokeWidth))
    ) {

        drawArc(
            color = color,
            -180f,
            180 * currentpercentage.value,
            useCenter = false,
            style = Stroke(strokeWidth.toPx(), cap = StrokeCap.Butt),


        )
        drawArc(
            color = Color.White,
            0f,
            -180+(180*currentpercentage.value),
            useCenter = false,
            style = Stroke(strokeWidth.toPx(), cap = StrokeCap.Butt) ,

        )
    }
    Canvas(modifier=Modifier.size(radius*2f+(strokeWidth/2))
    ) {

        drawArc(
            color = Color.Black,
            -180f,
            180f,
            useCenter = false,
            style = Stroke(15f, cap = StrokeCap.Butt)
        )

    }
    Canvas(modifier=Modifier.size(radius*2f-(strokeWidth*2f))
    ) {

        drawArc(
            color = Color.Black,
            -180f,
            180f,
            useCenter = false,
            style = Stroke(15f, cap = StrokeCap.Butt)
        )
        drawLine(
            color = Color.Black,
            start = Offset((radius*1.51f).toPx()+strokeWidth.toPx(), (radius/1.4f).toPx()),
            end = Offset((radius*1.5f).toPx(),(radius/1.38f).toPx()),
            strokeWidth=12f
        )
        drawLine(
            color = Color.Black,
            start = Offset(-strokeWidth.toPx(), (radius/1.4f).toPx()),
            end = Offset(0f,(radius/1.38f).toPx()),
            strokeWidth=12f
        )
    }
        Text(
            text = " "+(currentpercentage.value * number).toInt().toString()+"%",
            color = niceyellow,
            fontSize = fontSize,
            fontWeight = FontWeight.Bold,
        )


    }

}


