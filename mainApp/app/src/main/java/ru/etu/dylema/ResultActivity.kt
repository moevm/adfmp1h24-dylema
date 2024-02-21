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
import androidx.compose.runtime.MutableState
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
import ru.etu.dylema.domain.Ethic
import ru.etu.dylema.domain.UserPhilosophy

@Composable
fun ResultScreen(navController: NavController, philosophy: MutableState<UserPhilosophy>) {


    Box(
        Modifier.fillMaxSize()
    ) {

        Column(
            modifier = Modifier
                .background(Color(0xFFFFEBE3))
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally

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
                    onClick = {
                        navController.navigate("main_screen")
                    }
                ) {
                    Image(painter = painterResource(id = R.drawable.back), contentDescription = "")
                }

                Text(
                    text = "Результаты",
                    color = Color(0xFF707070),
                    fontSize = 20.sp,
                    fontFamily = FontFamily(Font(resId = R.font.ledger_regular)),
                    textAlign = TextAlign.Center
                )

                Button(
                    colors = ButtonDefaults.buttonColors(Color(0xFFFFEBE3)),
                    onClick = {
                        navController.navigate("main_screen")
                    }
                ) {
                    Image(painter = painterResource(id = R.drawable.close), contentDescription = "")
                }

            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(30.dp, 10.dp),
                verticalAlignment = Alignment.Top,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Ваша философская школа",
                    color = Color(0xFF707070),
                    fontSize = 26.sp,
                    fontFamily = FontFamily(Font(resId = R.font.ledger_regular)),
                    textAlign = TextAlign.Center
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 20.dp),
                verticalAlignment = Alignment.Top,
                horizontalArrangement = Arrangement.Center
            ) {
                when (philosophy.value.getEthic()) {
                    Ethic.EGOISM -> Image(
                        painter = painterResource(id = R.drawable.egoism),
                        contentDescription = Ethic.EGOISM.toString(),
                        alignment = Alignment.TopCenter
                    )

                    Ethic.UTILITARIANISM -> Image(
                        painter = painterResource(id = R.drawable.utilitarism),
                        contentDescription = Ethic.UTILITARIANISM.toString(),
                        alignment = Alignment.TopCenter
                    )

                    Ethic.LIBERTARIANISM -> Image(
                        painter = painterResource(id = R.drawable.libert),
                        contentDescription = Ethic.LIBERTARIANISM.toString(),
                        alignment = Alignment.TopCenter
                    )
                }
            }
            Text(
                text = philosophy.value.getEthic().toString(),
                color = Color(0xFF707070),
                fontSize = 24.sp,
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
                    colors = ButtonDefaults.buttonColors(Color(0xFFFFEBE3)),
                    onClick = {

                    },
                    modifier = Modifier
                        .border(1.dp, Color(0xFF707070))
                        .size(width = 210.dp, height = 55.dp)

                ) {
                    Text(
                        text = "Подробнее", color = Color(0xFF707070),
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

                    Image(
                        painter = painterResource(id = R.drawable.splitline),
                        contentDescription = ""
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))

                Button(
                    colors = ButtonDefaults.buttonColors(Color(0xFFFFEBE3)),
                    onClick = {
                        navController.navigate("total_result_screen")
                    },
                    modifier = Modifier
                        .border(1.dp, Color(0xFF707070))
                        .size(width = 210.dp, height = 55.dp)

                ) {
                    Text(
                        text = "Все результаты", color = Color(0xFF707070),
                        fontSize = 20.sp,
                        fontFamily = FontFamily(Font(resId = R.font.ledger_regular)),
                        textAlign = TextAlign.Center
                    )
                }

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ResultPreview() {
    val philosophy = remember {
        mutableStateOf(UserPhilosophy())
    }

    Box(
        Modifier.fillMaxSize()
    ) {

        Column(
            modifier = Modifier
                .background(Color(0xFFFFEBE3))
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally

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
                    onClick = { }
                ) {
                    Image(painter = painterResource(id = R.drawable.back), contentDescription = "")
                }

                Text(
                    text = "Результаты",
                    color = Color(0xFF707070),
                    fontSize = 20.sp,
                    fontFamily = FontFamily(Font(resId = R.font.ledger_regular)),
                    textAlign = TextAlign.Center
                )

                Button(
                    colors = ButtonDefaults.buttonColors(Color(0xFFFFEBE3)),
                    onClick = { }
                ) {
                    Image(painter = painterResource(id = R.drawable.close), contentDescription = "")
                }

            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(30.dp, 10.dp),
                verticalAlignment = Alignment.Top,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Ваша философская школа",
                    color = Color(0xFF707070),
                    fontSize = 26.sp,
                    fontFamily = FontFamily(Font(resId = R.font.ledger_regular)),
                    textAlign = TextAlign.Center
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 20.dp),
                verticalAlignment = Alignment.Top,
                horizontalArrangement = Arrangement.Center
            ) {
                when (philosophy.value.getEthic()) {
                    Ethic.EGOISM -> Image(
                        painter = painterResource(id = R.drawable.egoism),
                        contentDescription = Ethic.EGOISM.toString(),
                        alignment = Alignment.TopCenter
                    )

                    Ethic.UTILITARIANISM -> Image(
                        painter = painterResource(id = R.drawable.utilitarism),
                        contentDescription = Ethic.UTILITARIANISM.toString(),
                        alignment = Alignment.TopCenter
                    )

                    Ethic.LIBERTARIANISM -> Image(
                        painter = painterResource(id = R.drawable.libert),
                        contentDescription = Ethic.LIBERTARIANISM.toString(),
                        alignment = Alignment.TopCenter
                    )
                }
            }
            Text(
                text = philosophy.value.getEthic().toString(),
                color = Color(0xFF707070),
                fontSize = 24.sp,
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
                    colors = ButtonDefaults.buttonColors(Color(0xFFFFEBE3)),
                    onClick = {

                    },
                    modifier = Modifier
                        .border(1.dp, Color(0xFF707070))
                        .size(width = 210.dp, height = 55.dp)

                ) {
                    Text(
                        text = "Подробнее", color = Color(0xFF707070),
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

                    Image(
                        painter = painterResource(id = R.drawable.splitline),
                        contentDescription = ""
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))

                Button(
                    colors = ButtonDefaults.buttonColors(Color(0xFFFFEBE3)),
                    onClick = {

                    },
                    modifier = Modifier
                        .border(1.dp, Color(0xFF707070))
                        .size(width = 210.dp, height = 55.dp)

                ) {
                    Text(
                        text = "Все результаты", color = Color(0xFF707070),
                        fontSize = 20.sp,
                        fontFamily = FontFamily(Font(resId = R.font.ledger_regular)),
                        textAlign = TextAlign.Center
                    )
                }

            }
        }
    }

}
