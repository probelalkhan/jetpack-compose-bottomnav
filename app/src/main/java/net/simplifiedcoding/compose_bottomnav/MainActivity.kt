package net.simplifiedcoding.compose_bottomnav

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import net.simplifiedcoding.compose_bottomnav.ui.main.AppBottomNavigation
import net.simplifiedcoding.compose_bottomnav.ui.navigation.NAV_FAV
import net.simplifiedcoding.compose_bottomnav.ui.navigation.NAV_FEED
import net.simplifiedcoding.compose_bottomnav.ui.navigation.NAV_HOME
import net.simplifiedcoding.compose_bottomnav.ui.navigation.NAV_PROFILE

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { AppBottomNavigation(navController = navController) },
        drawerContent = { Text(text = "Drawer") }
    ) {
        NavHost(navController = navController, startDestination = NAV_HOME) {
            composable(NAV_HOME) { AppScreen(text = "Home Screen") }
            composable(NAV_FAV) { AppScreen(text = "Favourite Screen") }
            composable(NAV_FEED) { AppScreen(text = "Feed Screen") }
            composable(NAV_PROFILE) { AppScreen(text = "Profile Screen") }
        }
    }
}


@Composable
fun AppScreen(text: String) = Surface(modifier = Modifier.fillMaxSize()) {
    Text(text = text, fontSize = 32.sp)
}

@Preview
@Composable
fun DefaultPreview(){
    MainScreen()
}
