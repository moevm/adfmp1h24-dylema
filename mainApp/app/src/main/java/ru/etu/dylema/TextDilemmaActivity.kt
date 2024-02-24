package ru.etu.dylema

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import ru.etu.dylema.domain.UserPhilosophy
import ru.etu.dylema.domain.dilemma.TextDilemmaProvider
import java.io.File

@Composable
fun DilemmaScreen(
    navController: NavController,
    philosophy: UserPhilosophy,
    filesDir: File
) {
    val textDilemmaProvider = remember {
        mutableStateOf(TextDilemmaProvider())
    }
    val currentTask = remember {
        mutableStateOf(textDilemmaProvider.value.current())
    }

    Box(
        Modifier.fillMaxSize()
    ) {

        Column(
            modifier = Modifier
                .background(Color(0xFFFFEBE3))
                .fillMaxSize()
                .padding(12.dp)
                .background(Color(0xFFFFEBE3))
                .border(2.dp, Color(0xFFCCCCCC))
        ) {
            Row(modifier = Modifier.fillMaxWidth()) {
                Spacer(modifier = Modifier.height(30.dp))
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Absolute.SpaceBetween
            ) {
                Button(
                    colors = ButtonDefaults.buttonColors(Color(0xFFFFEBE3)),
                    onClick = { navController.navigate("main_screen") }
                ) {
                    Image(painter = painterResource(id = R.drawable.back), contentDescription = "")
                }

                Text(
                    text = "Вопрос " + textDilemmaProvider.value.currentNumber() + "/"
                            + textDilemmaProvider.value.totalCount(),
                    color = Color(0xFF707070),
                    fontSize = 26.sp,
                    fontFamily = FontFamily(Font(resId = R.font.ledger_regular)),
                    textAlign = TextAlign.Center
                )

                Button(
                    colors = ButtonDefaults.buttonColors(Color(0xFFFFEBE3)),
                    onClick = { navController.navigate("main_screen") }
                ) {
                    Image(painter = painterResource(id = R.drawable.close), contentDescription = "")
                }

            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 20.dp),
                verticalAlignment = Alignment.Top,
                horizontalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.man_sculpture),
                    contentDescription = "Andy Rubin",
                    alignment = Alignment.TopCenter
                )
            }
            Column() {
                Text(
                    text = currentTask.value.text,
                    color = Color(0xFF707070),
                    fontSize = 18.sp,
                    fontFamily = FontFamily(Font(resId = R.font.ledger_regular)),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(10.dp)
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(
                    colors = ButtonDefaults.buttonColors(Color(0xFFFFEBE3)),
                    onClick = {
                        val solution = currentTask.value.leftSolution
                        philosophy.accept(solution)

                        if (currentTask.value.isFinal) {
                            saveResults(filesDir, philosophy)
                            navController.navigate("result_screen")
                        } else {
                            val task = textDilemmaProvider.value.next()
                            currentTask.value = task
                        }
                    },
                    modifier = Modifier
                        .border(1.dp, Color(0xFF707070))
                        .size(width = 210.dp, height = 55.dp)

                ) {
                    Text(
                        text = "Первое", color = Color(0xFF707070),
                        fontSize = 24.sp,
                        fontFamily = FontFamily(Font(resId = R.font.ledger_regular)),
                        textAlign = TextAlign.Center
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = painterResource(id = R.drawable.splitline),
                        contentDescription = ""
                    )

                    Text(
                        text = " или ",
                        color = Color(0xFF707070),
                        fontSize = 20.sp,
                        fontFamily = FontFamily(Font(resId = R.font.ledger_regular)),
                        textAlign = TextAlign.Center
                    )

                    Image(
                        painter = painterResource(id = R.drawable.splitline),
                        contentDescription = ""
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))

                Button(
                    colors = ButtonDefaults.buttonColors(Color(0xFFFFEBE3)),
                    onClick = {
                        val solution = currentTask.value.rightSolution
                        philosophy.accept(solution)

                        if (currentTask.value.isFinal) {
                            saveResults(filesDir, philosophy)
                            navController.navigate("result_screen")
                        } else {
                            val task = textDilemmaProvider.value.next()
                            currentTask.value = task
                        }
                    },
                    modifier = Modifier
                        .border(1.dp, Color(0xFF707070))
                        .size(width = 210.dp, height = 55.dp)

                ) {
                    Text(
                        text = "Второе", color = Color(0xFF707070),
                        fontSize = 24.sp,
                        fontFamily = FontFamily(Font(resId = R.font.ledger_regular)),
                        textAlign = TextAlign.Center
                    )
                }

            }
        }
    }

}

private fun saveResults(filesDir: File, philosophy: UserPhilosophy) {
    val resultFile = File(filesDir, "user-results.json")
    philosophy.testName = "Дилемма"

    if (!resultFile.exists()) {
        resultFile.writeText("[]")
    }

    val results = Json.decodeFromString<ArrayList<UserPhilosophy>>(resultFile.readText())
    results.add(philosophy)

    resultFile.writeText(Json.encodeToString(results))
}