package ru.etu.dylema

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
import ru.etu.dylema.ui.theme.DylemaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val philosophy = remember {
                mutableStateOf(UserPhilosophy(time = System.currentTimeMillis()))
            }
            DylemaTheme {
                NavHost(navController = navController, startDestination = "main_screen") {
                    composable("main_screen") {
                        philosophy.value.reset()
                        MainMenu(navController)
                    }
                    composable("dilemma_screen") {
                        DilemmaScreen(navController = navController, philosophy = philosophy.value, filesDir = filesDir)
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
                        { type = NavType.LongType})
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

    Box(
        Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomStart
    ) {

        Column(
            modifier = Modifier
                .background(Color(0xFFFFEBE3))
                .fillMaxSize()
                .padding(12.dp)
                .background(Color(0xFFFFEBE3))
                .border(2.dp, Color(0xFFCCCCCC))
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(4f),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.column),
                    "",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 80.dp),
                    alignment = Alignment.Center
                )
                Text(
                    text = "Дилемма",
                    color = Color(0xFF707070),
                    fontSize = 44.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 30.dp, bottom = 40.dp),
                    fontFamily = FontFamily(Font(resId = R.font.ledger_regular)),
                    textAlign = TextAlign.Center
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(4f),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(
                    colors = ButtonDefaults.buttonColors(Color(0xFFFFEBE3)),
                    onClick = { navController.navigate("dilemma_screen") },
                    modifier = Modifier
                        .border(1.dp, Color(0xFF707070))
                        .size(width = 210.dp, height = 70.dp)

                ) {
                    Text(
                        text = "Опросник", color = Color(0xFF707070),
                        fontSize = 24.sp,
                        fontFamily = FontFamily(Font(resId = R.font.ledger_regular)),
                        textAlign = TextAlign.Center
                    )
                }
                Spacer(modifier = Modifier.height(30.dp))
                Button(
                    colors = ButtonDefaults.buttonColors(Color(0xFFFFEBE3)),
                    onClick = { navController.navigate("trolley_screen") },
                    modifier = Modifier
                        .border(1.dp, Color(0xFF707070))
                        .size(width = 210.dp, height = 70.dp)

                ) {
                    Text(
                        text = "Проблема вагонетки", color = Color(0xFF707070),
                        fontSize = 20.sp,
                        fontFamily = FontFamily(Font(resId = R.font.ledger_regular)),
                        textAlign = TextAlign.Center
                    )
                }
                Spacer(modifier = Modifier.height(30.dp))
                Button(
                    colors = ButtonDefaults.buttonColors(Color(0xFFFFEBE3)),
                    onClick = { navController.navigate("total_result_screen") },
                    modifier = Modifier
                        .border(1.dp, Color(0xFF707070))
                        .size(width = 210.dp, height = 70.dp)

                ) {
                    Text(
                        text = "Результаты", color = Color(0xFF707070),
                        fontSize = 26.sp,
                        fontFamily = FontFamily(Font(resId = R.font.ledger_regular)),
                        textAlign = TextAlign.Center
                    )
                }
            }
            Column(modifier = Modifier.weight(2f)) {

            }
        }
        Image(
            painter = painterResource(id = R.drawable.man_sculpture), contentDescription = "",
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Box(
        Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomStart
    ) {

        Column(
            modifier = Modifier
                .background(Color(0xFFFFEBE3))
                .fillMaxSize()
                .padding(12.dp)
                .background(Color(0xFFFFEBE3))
                .border(2.dp, Color(0xFFCCCCCC))
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(3f),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.column),
                    "",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 80.dp),
                    alignment = Alignment.Center
                )
                Text(
                    text = "Дилемма",
                    color = Color(0xFF707070),
                    fontSize = 44.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 30.dp, bottom = 40.dp),
                    fontFamily = FontFamily(Font(resId = R.font.ledger_regular)),
                    textAlign = TextAlign.Center
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(3f),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(
                    colors = ButtonDefaults.buttonColors(Color(0xFFFFEBE3)),
                    onClick = { },
                    modifier = Modifier
                        .border(1.dp, Color(0xFF707070))
                        .size(width = 210.dp, height = 55.dp)

                ) {
                    Text(
                        text = "Играть", color = Color(0xFF707070),
                        fontSize = 26.sp,
                        fontFamily = FontFamily(Font(resId = R.font.ledger_regular)),
                        textAlign = TextAlign.Center
                    )
                }
                Spacer(modifier = Modifier.height(30.dp))
                Button(
                    colors = ButtonDefaults.buttonColors(Color(0xFFFFEBE3)),
                    onClick = { },
                    modifier = Modifier
                        .border(1.dp, Color(0xFF707070))
                        .size(width = 210.dp, height = 55.dp)

                ) {
                    Text(
                        text = "Результаты", color = Color(0xFF707070),
                        fontSize = 26.sp,
                        fontFamily = FontFamily(Font(resId = R.font.ledger_regular)),
                        textAlign = TextAlign.Center
                    )
                }
            }
            Column(modifier = Modifier.weight(2f)) {

            }
        }
        Image(
            painter = painterResource(id = R.drawable.man_sculpture), contentDescription = "",
        )
    }
}
