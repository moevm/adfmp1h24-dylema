package ru.etu.dylema

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import ru.etu.dylema.domain.DilemmaType
import ru.etu.dylema.domain.UserSession
import ru.etu.dylema.page.About
import ru.etu.dylema.page.ChooseDilemma
import ru.etu.dylema.page.dilemma.TextDilemma
import ru.etu.dylema.page.ResultDescription
import ru.etu.dylema.page.MainMenu
import ru.etu.dylema.page.ResultScreen
import ru.etu.dylema.page.ResultHistory
import ru.etu.dylema.page.dilemma.TrolleyDilemma
import ru.etu.dylema.ui.theme.DilemmaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        // TODO: result are not saved in the device?
        // TODO: check that all pages have consistent title sizes and positions. Same with close/return buttons

        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val session = remember {
                mutableStateOf(
                    UserSession(filesDir)
                )
            }

            val controllers = remember {
                mutableStateOf(
                    session.value.controllers
                )
            }

            DilemmaTheme {
                NavHost(navController = navController, startDestination = "main_screen") {
                    composable("main_screen") {
                        session.value.reset()
                        MainMenu(navController)
                    }
                    composable("about") {
                        About(navController)
                    }
                    composable("choose_dilemma_screen") {
                        ChooseDilemma(navController)
                    }
                    composable("text_dilemma_screen") {
                        session.value.currentDilemma = DilemmaType.TEXT_DILEMMA
                        val controller = controllers.value[DilemmaType.TEXT_DILEMMA]!!
                        if (controller.initTime == -1L)
                            controller.init()
                        TextDilemma(
                            navController = navController,
                            dilemmaController = controller
                        )
                    }
                    composable("trolley_dilemma_screen") {
                        session.value.currentDilemma = DilemmaType.TROLLEY_DILEMMA
                        val controller = controllers.value[DilemmaType.TROLLEY_DILEMMA]!!
                        if (controller.initTime == -1L)
                            controller.init()
                        TrolleyDilemma(
                            navController = navController,
                            dilemmaController = controller
                        )
                    }
                    composable("result_screen") {
                        if (session.value.currentDilemma == null || !controllers.value[session.value.currentDilemma]!!.hasFinished) {
                            navController.navigate("main_screen")
                        }
                        Log.v("qweqweqweqew", controllers.value[session.value.currentDilemma]!!.getResult().time.toString())
                        ResultScreen(navController, controllers.value[session.value.currentDilemma]!!.getResult())
                    }
                    composable("total_result_screen") {
                        ResultHistory(navController, filesDir)
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
