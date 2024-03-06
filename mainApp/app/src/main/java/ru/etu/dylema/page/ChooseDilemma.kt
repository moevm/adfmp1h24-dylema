package ru.etu.dylema.page

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
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
import androidx.navigation.compose.rememberNavController
import ru.etu.dylema.R

@Composable
fun ChooseDilemma(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFEBE3)),
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
                tint = Color(0xFF000000)
            )
        }
        Text(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .offset(0.dp, 35.dp),
            text = "Выберите вид теста",
            color = Color(0xFF707070),
            fontSize = 23.sp,
            fontFamily = FontFamily(Font(resId = R.font.ledger_regular)),
            textAlign = TextAlign.Center
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp, 77.dp, 20.dp, 30.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Button(
                modifier = Modifier
                    .fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(Color(0xFFF4E0D9)),
                shape = RectangleShape,
                border = BorderStroke(1.dp, Color(0xFF707070)),
                contentPadding = PaddingValues(0.dp, 0.dp, 0.dp, 8.dp),
                onClick = { navController.navigate("dilemma_screen") }

            ) {
                Text(
                    text = "Дилемма",
                    color = Color(0xFF707070),
                    fontSize = 20.sp,
                    lineHeight = 20.sp,
                    fontFamily = FontFamily(Font(resId = R.font.ledger_regular)),
                    textAlign = TextAlign.Center
                )
            }

            Spacer(modifier = Modifier.height(15.dp))

            Button(
                modifier = Modifier
                    .fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(Color(0xFFF4E0D9)),
                shape = RectangleShape,
                border = BorderStroke(1.dp, Color(0xFF707070)),
                contentPadding = PaddingValues(0.dp, 0.dp, 0.dp, 8.dp),
                onClick = { navController.navigate("trolley_screen") }

            ) {
                Text(
                    text = "Вагонетка",
                    color = Color(0xFF707070),
                    fontSize = 20.sp,
                    lineHeight = 20.sp,
                    fontFamily = FontFamily(Font(resId = R.font.ledger_regular)),
                    textAlign = TextAlign.Center
                )
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
fun ChooseDilemmaPreview() {
    val navController = rememberNavController()
    ChooseDilemma(
        navController
    )
}
