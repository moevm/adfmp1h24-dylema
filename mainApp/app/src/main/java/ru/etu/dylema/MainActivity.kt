package ru.etu.dylema

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.etu.dylema.ui.theme.DylemaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            DylemaTheme {
                NavHost(navController = navController, startDestination = "main_screen") {
                    composable("main_screen") {
                        MainMenu {
                            navController.navigate("dilemma_screen")
                        }
                    }
                    composable("dilemma_screen") {
                        DilemmaScreen(onClick = {
                                                navController.navigate("main_screen")
                        }, img = painterResource(id = R.drawable.img))
                    }
                }

            }
        }

    }
}

@Composable
fun Greeting() {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Начать")
        }
    }
}

@Composable
fun MainMenu(onClick: () -> Unit) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { onClick() }) {
            Text(text = "Начать")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DylemaTheme {
        Greeting()
    }
}
