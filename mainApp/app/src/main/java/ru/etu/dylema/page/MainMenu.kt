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
fun MainMenu(navController: NavController) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFEBE3)),
        contentAlignment = Alignment.BottomStart
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp, 30.dp)
                .border(3.dp, Color(0xFFCCCCCC)),
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
                    color = Color(0xFF707070),
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
                    colors = ButtonDefaults.buttonColors(Color(0xFFF4E0D9)),
                    shape = RectangleShape,
                    border = BorderStroke(1.dp, Color(0xFF707070)),
                    contentPadding = PaddingValues(0.dp, 0.dp, 0.dp, 8.dp),
                    onClick = { navController.navigate("choose_dilemma_screen") }
                ) {
                    Text(
                        text = "Играть",
                        color = Color(0xFF707070),
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
                    colors = ButtonDefaults.buttonColors(Color(0xFFF4E0D9)),
                    shape = RectangleShape,
                    border = BorderStroke(1.dp, Color(0xFF707070)),
                    contentPadding = PaddingValues(0.dp, 0.dp, 0.dp, 8.dp),
                    onClick = { navController.navigate("total_result_screen") },
                ) {
                    Text(
                        text = "Результаты",
                        color = Color(0xFF707070),
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
                    colors = ButtonDefaults.buttonColors(Color(0xFFF4E0D9)),
                    shape = RectangleShape,
                    border = BorderStroke(1.dp, Color(0xFF707070)),
                    contentPadding = PaddingValues(0.dp, 0.dp, 0.dp, 8.dp),
                    onClick = { navController.navigate("about") },
                ) {
                    Text(
                        text = "Справка",
                        color = Color(0xFF707070),
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