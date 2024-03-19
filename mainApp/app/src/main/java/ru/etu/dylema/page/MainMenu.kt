package ru.etu.dylema.page

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import ru.etu.dylema.R
import ru.etu.dylema.ui.theme.BackgroundBorderColor
import ru.etu.dylema.ui.theme.BackgroundColor
import ru.etu.dylema.ui.theme.ButtonBackgroundColor
import ru.etu.dylema.ui.theme.TextColor
import ru.etu.dylema.ui.theme.TextColorDisabled

@Composable
fun MainMenu(navController: NavController) {

    val isResultsHistoryButtonDisabled = false

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundColor),
        contentAlignment = Alignment.BottomStart
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp, 30.dp)
                .border(3.dp, BackgroundBorderColor),
            verticalArrangement = Arrangement.Top
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 80.dp, 0.dp, 40.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    modifier = Modifier
                        .width(80.dp)
                        .height(80.dp),
                    painter = painterResource(id = R.drawable.column),
                    contentDescription = "",
                    alignment = Alignment.Center
                )
                Spacer(modifier = Modifier.height(30.dp))
                Text(
                    modifier = Modifier
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    color = TextColor,
                    fontSize = 50.sp,
                    fontFamily = FontFamily(Font(resId = R.font.ledger_regular)),
                    text = "Дилемма"
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 30.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(
                    modifier = Modifier
                        .size(width = 210.dp, height = 55.dp),
                    colors = ButtonDefaults.buttonColors(ButtonBackgroundColor),
                    shape = RectangleShape,
                    border = BorderStroke(1.dp, TextColor),
                    contentPadding = PaddingValues(0.dp, 0.dp, 0.dp, 8.dp),
                    onClick = { navController.navigate("choose_dilemma_screen") }
                ) {
                    Text(
                        text = "Играть",
                        color = TextColor,
                        fontSize = 32.sp,
                        lineHeight = 32.sp,
                        fontFamily = FontFamily(Font(resId = R.font.ledger_regular)),
                        textAlign = TextAlign.Center
                    )
                }
                Spacer(modifier = Modifier.height(30.dp))
                // TODO: This button should block if there isn't any results stored!
                Button(
                    modifier = Modifier
                        .width(210.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = ButtonBackgroundColor,
                        contentColor = TextColor,
                        disabledContainerColor = ButtonBackgroundColor,
                        disabledContentColor = TextColorDisabled
                    ),
                    shape = RectangleShape,
                    border = BorderStroke(
                        1.dp,
                        if (isResultsHistoryButtonDisabled) TextColorDisabled else TextColor
                    ),
                    contentPadding = PaddingValues(0.dp, 0.dp, 0.dp, 8.dp),
                    enabled = !isResultsHistoryButtonDisabled,
                    onClick = { navController.navigate("total_result_screen") },
                ) {
                    Text(
                        text = "Результаты",
                        fontSize = 32.sp,
                        lineHeight = 32.sp,
                        fontFamily = FontFamily(Font(resId = R.font.ledger_regular)),
                        textAlign = TextAlign.Center
                    )
                }
                Spacer(modifier = Modifier.height(30.dp))
                Button(
                    modifier = Modifier
                        .width(210.dp),
                    colors = ButtonDefaults.buttonColors(ButtonBackgroundColor),
                    shape = RectangleShape,
                    border = BorderStroke(1.dp, TextColor),
                    contentPadding = PaddingValues(0.dp, 0.dp, 0.dp, 8.dp),
                    onClick = { navController.navigate("about") },
                ) {
                    Text(
                        text = "Справка",
                        color = TextColor,
                        fontSize = 32.sp,
                        lineHeight = 32.sp,
                        fontFamily = FontFamily(Font(resId = R.font.ledger_regular)),
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
        Image(
            modifier = Modifier
                .width(250.dp)
                .height(204.dp),
            painter = painterResource(id = R.drawable.man_sculpture), contentDescription = "",
        )
    }
}

@Preview(
    showBackground = true,
    widthDp = 390,
    heightDp = 844

)
@Composable
fun MainMenuPreview() {
    val navController = rememberNavController()
    MainMenu(
        navController
    )
}