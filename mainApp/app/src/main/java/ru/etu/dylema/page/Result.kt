package ru.etu.dylema.page

import android.content.Intent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import ru.etu.dylema.R
import ru.etu.dylema.domain.base_dilemma.DilemmaResult
import ru.etu.dylema.domain.createTextForShare
import ru.etu.dylema.domain.text_dilemma.TextDilemmaController
import ru.etu.dylema.ui.theme.BackgroundColor
import ru.etu.dylema.ui.theme.ButtonBackgroundColor
import ru.etu.dylema.ui.theme.TextColor
import java.io.File

@Composable
fun ResultScreen(navController: NavController, result: DilemmaResult, startActivity: (Intent) -> Unit) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundColor),
    ) {

        TextButton(
            modifier = Modifier

                .align(Alignment.TopStart)
                .offset((20).dp, 20.dp)
                .size(width = 35.dp, height = 35.dp),
            shape = RectangleShape,
            contentPadding = PaddingValues(),
            onClick = { navController.navigate("main_screen") }
        ) {
            Icon(
                modifier = Modifier.size(35.dp),
                imageVector = Icons.Outlined.ArrowBack,
                contentDescription = "Back button",
                tint = Color.Black
            )
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp, 30.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Результаты: " + result.dilemmaType.title,
                color = TextColor,
                fontSize = 23.sp,
                fontFamily = FontFamily(Font(resId = R.font.ledger_regular)),
                textAlign = TextAlign.Center
            )
            Text(
                text = "Ваша \nфилософская школа",
                color = TextColor,
                fontSize = 32.sp,
                lineHeight = 35.sp,
                fontFamily = FontFamily(Font(resId = R.font.ledger_regular)),
                textAlign = TextAlign.Center
            )
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1.6f)
                    .padding(0.dp, 20.dp),
                painter = painterResource(id = result.ethic.imageId),
                contentDescription = result.ethic.title,
                alignment = Alignment.TopCenter
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(2f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    modifier = Modifier.padding(0.dp, 10.dp),
                    text = result.ethic.title,
                    color = TextColor,
                    fontSize = 40.sp,
                    fontFamily = FontFamily(Font(resId = R.font.ledger_regular)),
                    textAlign = TextAlign.Center,
                )
                Spacer(modifier = Modifier.height(20.dp))
                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.SpaceBetween,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Button(
                        modifier = Modifier
                            .fillMaxWidth(0.8f),
                        colors = ButtonDefaults.buttonColors(ButtonBackgroundColor),
                        shape = RectangleShape,
                        border = BorderStroke(1.dp, TextColor),
                        contentPadding = PaddingValues(0.dp, 0.dp, 0.dp, 8.dp),
                        onClick = {
                            navController.navigate("ethic_intro_screen?time=" + result.time)
                        }
                    ) {
                        Text(
                            text = "Подробнее",
                            color = TextColor,
                            fontSize = 32.sp,
                            fontFamily = FontFamily(Font(resId = R.font.ledger_regular)),
                            textAlign = TextAlign.Center
                        )
                    }

                    Spacer(modifier = Modifier.height(30.dp))

                    Button(
                        modifier = Modifier
                            .fillMaxWidth(0.8f),
                        colors = ButtonDefaults.buttonColors(ButtonBackgroundColor),
                        shape = RectangleShape,
                        border = BorderStroke(1.dp, TextColor),
                        contentPadding = PaddingValues(0.dp, 0.dp, 0.dp, 8.dp),
                        onClick = {
                            val sendIntent: Intent = Intent().apply {
                                action = Intent.ACTION_SEND
                                putExtra(Intent.EXTRA_TEXT, createTextForShare(result))
                                type = "text/plain"
                            }

                            val shareIntent = Intent.createChooser(sendIntent, null)
                            startActivity(shareIntent)
                        }
                    ) {
                        Text(
                            text = "Поделиться",
                            color = TextColor,
                            fontSize = 32.sp,
                            fontFamily = FontFamily(Font(resId = R.font.ledger_regular)),
                            textAlign = TextAlign.Center
                        )
                    }

                    Spacer(modifier = Modifier.height(30.dp))

                    Button(
                        modifier = Modifier
                            .fillMaxWidth(0.8f),
                        colors = ButtonDefaults.buttonColors(ButtonBackgroundColor),
                        shape = RectangleShape,
                        border = BorderStroke(1.dp, TextColor),
                        contentPadding = PaddingValues(0.dp, 0.dp, 0.dp, 8.dp),
                        onClick = {
                            navController.navigate("total_result_screen")
                        }
                    ) {
                        Text(
                            text = "Все результаты", color = TextColor,
                            fontSize = 32.sp,
                            fontFamily = FontFamily(Font(resId = R.font.ledger_regular)),
                            textAlign = TextAlign.Center
                        )
                    }

                }
            }

        }
    }
}

@Preview(
    showBackground = true,
    widthDp = 390,
    heightDp = 844
)
@Composable
fun ResultPreview() {
    val navController = rememberNavController()
    val controller = TextDilemmaController(File(""))
    controller.init()
    controller.applyLeft()
    controller.applyLeft()
    controller.applyLeft()

    ResultScreen(
        navController,
        controller.getResult()
    ) {

    }
}