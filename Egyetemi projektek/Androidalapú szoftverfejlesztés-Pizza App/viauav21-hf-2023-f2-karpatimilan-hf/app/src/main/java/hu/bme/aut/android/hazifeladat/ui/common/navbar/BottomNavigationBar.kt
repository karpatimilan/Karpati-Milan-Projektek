package hu.bme.aut.android.hazifeladat.ui.common.navbar

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import hu.bme.aut.android.hazifeladat.ui.theme.niceyellow


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomNavigationBar(
    items:List<NavigationBarItem>,
    modifier: Modifier =Modifier,
    onItemClick:(NavigationBarItem)->Unit,
    actualroute:String
    ) {

    NavigationBar(
        modifier = modifier.height(78.dp),
        containerColor = niceyellow,


    ) {
        items.forEach { item ->
            val selected = item.route == actualroute
            NavigationBarItem(
                selected =selected,
                onClick = { onItemClick(item) },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color.Black,
                    unselectedIconColor = Color.Gray,
                    indicatorColor = niceyellow),
                icon = {    Column(horizontalAlignment = CenterHorizontally) {
                    if(item.badgeCount > 0) {
                        BadgedBox( badge = { Badge { Text(item.badgeCount.toString()) } } ) {
                            Icon(
                                imageVector = item.icon,
                                contentDescription = item.name ,
                                modifier = Modifier.size(32.dp)
                            )
                        }
                    } else {
                        Icon(
                            imageVector = item.icon,
                            contentDescription = item.name ,
                            modifier = Modifier.size(32.dp)
                        )
                    }
                        Text(
                            text = item.name,
                            textAlign = TextAlign.Center,
                            fontSize = 15.sp,
                        )

                }

                })


        }

    }
}





