package ru.etu.dylema

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import ru.etu.dylema.domain.UserPhilosophy
import ru.etu.dylema.page.About
import ru.etu.dylema.page.dilemma.DilemmaScreen
import ru.etu.dylema.page.ResultDescription
import ru.etu.dylema.page.MainMenu
import ru.etu.dylema.page.ResultScreen
import ru.etu.dylema.page.TotalResultScreen
import ru.etu.dylema.page.dilemma.TrolleyScreen
import ru.etu.dylema.ui.theme.DilemmaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        // TODO: result are not saved in the device!
        // TODO: check that all pages have consistent title sizes and positions. Same with close/return buttons

        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val philosophy = remember {
                mutableStateOf(UserPhilosophy(time = System.currentTimeMillis()))
            }
            DilemmaTheme {
                NavHost(navController = navController, startDestination = "main_screen") {
                    composable("main_screen") {
                        philosophy.value.reset()
                        MainMenu(navController)
                    }
                    composable("about") {
                        About(navController)
                    }
                    composable("dilemma_screen") {
                        DilemmaScreen(
                            navController = navController,
                            philosophy = philosophy.value,
                            filesDir = filesDir
                        )
                    }
                    composable("trolley_screen") {
                        TrolleyScreen(navController, philosophy.value, filesDir)
                    }
                    composable("result_screen") {
                        ResultScreen(navController, philosophy.value)
                    }
                    composable("total_result_screen") {
                        TotalResultScreen(navController, filesDir)
                    }
                    composable(
                        "ethic_intro_screen?time={time}",
                        arguments = listOf(navArgument("time")
                        { type = NavType.LongType })
                    ) { entry ->
                        ResultDescription(
                            entry.arguments?.getLong("time")!!,
                            navController,
                            filesDir
                        )
                    }

                }

            }
        }

    }
}
