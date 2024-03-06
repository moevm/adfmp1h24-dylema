package ru.etu.dylema.page.dilemma

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
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
import androidx.navigation.compose.rememberNavController
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import ru.etu.dylema.R
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
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFEBE3)),
    ) {
        TextButton(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .offset((-30).dp, 40.dp)
                .size(width = 35.dp, height = 35.dp),
            shape = RectangleShape,
            contentPadding = PaddingValues(),
            // TODO: Add confirmation window
            onClick = { navController.navigate("main_screen") }
        ) {
            Icon(
                modifier = Modifier.size(35.dp),
                imageVector = Icons.Outlined.Close,
                contentDescription = "Close button",
                tint = Color(0xFF000000)
            )
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp, 30.dp)
                .border(3.dp, Color(0xFFCCCCCC)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                modifier = Modifier
                    .padding(0.dp, 50.dp, 0.dp, 0.dp),
                text = "Вопрос " + textDilemmaProvider.value.currentNumber() + "/"
                        + textDilemmaProvider.value.totalCount(),
                color = Color(0xFF707070),
                fontSize = 24.sp,
                fontFamily = FontFamily(Font(resId = R.font.ledger_regular))
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(2f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // TODO: Add progress bar (https://developer.android.com/jetpack/compose/components/progress)
                Spacer(modifier = Modifier.height(30.dp))
                Text(
                    text = currentTask.value.text,
                    color = Color(0xFF707070),
                    fontSize = 18.sp,
                    fontFamily = FontFamily(Font(resId = R.font.ledger_regular)),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(10.dp)
                )
                Spacer(modifier = Modifier.height(30.dp))
                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.SpaceBetween,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // TODO: buttons should stay in one place on each question
                    Button(
                        modifier = Modifier
                            .fillMaxWidth(0.9f),
                        colors = ButtonDefaults.buttonColors(Color(0xFFF4E0D9)),
                        shape = RectangleShape,
                        border = BorderStroke(1.dp, Color(0xFF707070)),
                        contentPadding = PaddingValues(0.dp, 0.dp, 0.dp, 8.dp),
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
                        }
                    ) {
                        Text(
                            text = "Первое", color = Color(0xFF707070),
                            fontSize = 24.sp,
                            fontFamily = FontFamily(Font(resId = R.font.ledger_regular)),
                            textAlign = TextAlign.Center
                        )
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(0.9f),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(
                            modifier = Modifier
                                .weight(1f)
                                .height(1.dp)
                                .border(BorderStroke(1.dp, Color(0xFF707070)))
                        ){}

                        Text(
                            text = " или ",
                            color = Color(0xFF707070),
                            fontSize = 20.sp,
                            fontFamily = FontFamily(Font(resId = R.font.ledger_regular)),
                            textAlign = TextAlign.Center
                        )

                        Column(
                            modifier = Modifier
                                .weight(1f)
                                .height(1.dp)
                                .border(BorderStroke(1.dp, Color(0xFF707070)))
                        ){}
                    }
                    Spacer(modifier = Modifier.height(10.dp))

                    Button(
                        modifier = Modifier
                            .fillMaxWidth(0.9f),
                        colors = ButtonDefaults.buttonColors(Color(0xFFF4E0D9)),
                        shape = RectangleShape,
                        border = BorderStroke(1.dp, Color(0xFF707070)),
                        contentPadding = PaddingValues(0.dp, 0.dp, 0.dp, 8.dp),
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
                        }
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

            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.7f),
                painter = painterResource(id = R.drawable.man_sculpture),
                contentDescription = "Andy Rubin"
            )
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

@Preview(
    showBackground = true,
    widthDp = 390,
    heightDp = 844
)
@Composable
fun DilemmaScreenPreview() {
    val navController = rememberNavController()
    val philosophy = remember {
        mutableStateOf(UserPhilosophy(time = System.currentTimeMillis()))
    }
    DilemmaScreen(
        navController,
        philosophy.value,
        File("")
    )
}

