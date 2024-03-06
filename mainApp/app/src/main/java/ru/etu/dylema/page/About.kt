package ru.etu.dylema.page

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
fun About(navController: NavController) {
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
            text = "Справка",
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
            Text(
                text = "Данное приложение разрабатывалось в рамках прохождения курса “Разработка приложений для мобильных платформ” СПбГЭТУ “ЛЭТИ”",
                color = Color(0xFF707070),
                fontSize = 24.sp,
                fontFamily = FontFamily(Font(resId = R.font.ledger_regular)),
                textAlign = TextAlign.Center
            )
            
            Spacer(modifier = Modifier.height(15.dp))

            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Разработчики:",
                color = Color(0xFF707070),
                fontSize = 24.sp,
                fontFamily = FontFamily(Font(resId = R.font.ledger_regular)),
                textAlign = TextAlign.Left
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(0.dp, 10.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Top
            ) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Табаков Павел Леонидович",
                    color = Color(0xFF000000),
                    fontSize = 24.sp,
                    fontFamily = FontFamily(Font(resId = R.font.ledger_regular)),
                    textAlign = TextAlign.Left
                )

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Аристархов Илья Евгеньевич",
                    color = Color(0xFF000000),
                    fontSize = 24.sp,
                    fontFamily = FontFamily(Font(resId = R.font.ledger_regular)),
                    textAlign = TextAlign.Left
                )

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Максимов Евгений Алексеевич",
                    color = Color(0xFF000000),
                    fontSize = 24.sp,
                    fontFamily = FontFamily(Font(resId = R.font.ledger_regular)),
                    textAlign = TextAlign.Left
                )
            }

            Spacer(modifier = Modifier.height(15.dp))

            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "А какой вы волк?",
                color = Color(0xFF707070),
                fontSize = 32.sp,
                fontFamily = FontFamily(Font(resId = R.font.ledger_regular)),
                textAlign = TextAlign.Center
            )

            Image(
                modifier = Modifier.weight(0.3f),
                painter = painterResource(id = R.drawable.wolf),
                contentDescription = ""
            )
        }
    }
}

@Preview(
    showBackground = true,
    widthDp = 390,
    heightDp = 844
)
@Composable
fun AboutPreview() {
    val navController = rememberNavController()
    About(
        navController
    )
}