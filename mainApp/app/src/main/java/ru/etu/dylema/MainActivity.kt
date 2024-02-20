package ru.etu.dylema

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.etu.dylema.domain.UserPhilosophy
import ru.etu.dylema.ui.theme.DylemaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val philosophy = remember {
                mutableStateOf(UserPhilosophy())
            }
            DylemaTheme {
                NavHost(navController = navController, startDestination = "main_screen") {
                    composable("main_screen") {
                        MainMenu(navController)
                    }
                    composable("dilemma_screen") {
                        DilemmaScreen(navController, philosophy)
                    }
                    composable("result_screen") {
                        ResultScreen(navController, philosophy)
                    }
                    composable("total_result_screen") {
                        TotalResultScreen(navController)
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
        Row {
            Button(onClick = { }) {
                Text(text = "Начать")
            }
        }
        Row {
            Button(onClick = { }) {
                Text(text = "Результаты")
            }
        }
    }
}

@Composable
fun MainMenu(navController: NavController) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row {
            Button(onClick = { navController.navigate("dilemma_screen") }) {
                Text(text = "Начать")
            }
        }
        Row {
            Button(onClick = { navController.navigate("total_result_screen") }) {
                Text(text = "Результаты")
            }
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
