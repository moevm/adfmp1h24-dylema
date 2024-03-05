package ru.etu.dylema

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import ru.etu.dylema.domain.UserPhilosophy
import ru.etu.dylema.page.DilemmaScreen
import ru.etu.dylema.page.EthicIntroduction
import ru.etu.dylema.page.MainMenu
import ru.etu.dylema.page.ResultScreen
import ru.etu.dylema.page.TotalResultScreen
import ru.etu.dylema.page.TrolleyScreen
import ru.etu.dylema.ui.theme.DilemmaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        // TODO: result are not saved in the device!
        // TODO: check all fontSizes
        // TODO: all buttons should have background - see figma

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
                        EthicIntroduction(
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
