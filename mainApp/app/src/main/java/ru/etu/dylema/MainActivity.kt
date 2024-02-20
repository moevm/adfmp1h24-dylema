package ru.etu.dylema

import android.os.Bundle
import android.util.Log
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
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
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
                        MainMenu(navController)
                    }
                    composable("dilemma_screen") {
                        DilemmaScreen(navController)
                    }
                }

            }
        }

    }
}

class TaskProvider() {

    private val tasks = arrayListOf<Task>(
        Task(R.drawable.img),
        Task(R.drawable.ic_launcher_background),
        Task(R.drawable.ic_launcher_foreground)
    );

    private var pointer = 0;

    fun next(): Task {
        if (pointer == (tasks.size - 1)) {
            return tasks[pointer]
        }

        return tasks[++pointer]
    }

    fun prev(): Task {
        if (pointer <= 0) {
            return tasks[pointer]
        }

        return tasks[--pointer]
    }

    fun current(): Task {
        return tasks[pointer]
    }

}

class Task(var imageId: Int) {

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
fun MainMenu(navController: NavController) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { navController.navigate("dilemma_screen") }) {
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
