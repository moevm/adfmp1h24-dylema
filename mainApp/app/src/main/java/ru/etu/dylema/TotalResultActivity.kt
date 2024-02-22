package ru.etu.dylema

import android.content.res.AssetManager
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlinx.serialization.json.Json
import ru.etu.dylema.domain.UserPhilosophy
import java.io.BufferedReader
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun TotalResultScreen(navController: NavController, assets : AssetManager) {

    val philosophy = remember {
        mutableStateOf(UserPhilosophy())
    }

    val results = remember {
        mutableStateOf(Json.decodeFromString<List<UserPhilosophy>>(
            BufferedReader(assets.open("user-results.json").reader()).readText())
        )
    }

    Box(
        Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomEnd
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
                horizontalArrangement = Arrangement.Absolute.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
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
                    text = "Все результаты",
                    color = Color(0xFF707070),
                    fontSize = 22.sp,
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

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp, 0.dp, 15.dp, 0.dp),
                verticalArrangement = Arrangement.SpaceAround,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(painter = painterResource(id = R.drawable.spacer), contentDescription = "",
                    Modifier
                        .fillMaxWidth()
                        .aspectRatio(ratio = 100f),
                    contentScale = ContentScale.Fit)

                for (r in results.value) {
                    Spacer(modifier = Modifier.height(10.dp))
                    ResultLine(result = r)
                    Spacer(modifier = Modifier.height(10.dp))
                    Image(painter = painterResource(id = R.drawable.spacer), contentDescription = "",
                        Modifier
                            .fillMaxWidth()
                            .aspectRatio(ratio = 100f),
                        contentScale = ContentScale.Fit)
                }
            }

            Spacer(modifier = Modifier.height(20.dp))


            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(
                    colors = ButtonDefaults.buttonColors(Color(0xFFFFEBE3)),
                    onClick = {

                    },
                    modifier = Modifier
                        .border(1.dp, Color(0xFF707070))

                ) {
                    Text(
                        text = "Удалить все результаты", color = Color(0xFF707070),
                        fontSize = 22.sp,
                        fontFamily = FontFamily(Font(resId = R.font.ledger_regular)),
                        textAlign = TextAlign.Center
                    )
                }

                Spacer(modifier = Modifier.height(35.dp))

            }
        }
        Image(painter = painterResource(id = R.drawable.angel), contentDescription = "",
            alpha = 0.2f)
    }
}

@Preview(showBackground = true)
@Composable
fun TotalResultPreview() {
    val philosophy = remember {
        mutableStateOf(UserPhilosophy())
    }
    val results = remember {
        mutableStateOf(listOf(philosophy.value, philosophy.value))
    }

    Box(
        Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomEnd
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
                horizontalArrangement = Arrangement.Absolute.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    colors = ButtonDefaults.buttonColors(Color(0xFFFFEBE3)),
                    onClick = { }
                ) {
                    Image(painter = painterResource(id = R.drawable.back), contentDescription = "")
                }

                Text(
                    text = "Все результаты",
                    color = Color(0xFF707070),
                    fontSize = 22.sp,
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

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp, 0.dp, 15.dp, 0.dp),
                verticalArrangement = Arrangement.SpaceAround,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(painter = painterResource(id = R.drawable.spacer), contentDescription = "",
                    Modifier
                        .fillMaxWidth()
                        .aspectRatio(ratio = 100f),
                    contentScale = ContentScale.Fit)

                for (r in results.value) {
                    Spacer(modifier = Modifier.height(10.dp))
                    ResultLine(result = r)
                    Spacer(modifier = Modifier.height(10.dp))
                    Image(painter = painterResource(id = R.drawable.spacer), contentDescription = "",
                        Modifier
                            .fillMaxWidth()
                            .aspectRatio(ratio = 100f),
                        contentScale = ContentScale.Fit)
                }
            }

            Spacer(modifier = Modifier.height(20.dp))


            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(
                    colors = ButtonDefaults.buttonColors(Color(0xFFFFEBE3)),
                    onClick = {

                    },
                    modifier = Modifier
                        .border(1.dp, Color(0xFF707070))

                ) {
                    Text(
                        text = "Удалить все результаты", color = Color(0xFF707070),
                        fontSize = 22.sp,
                        fontFamily = FontFamily(Font(resId = R.font.ledger_regular)),
                        textAlign = TextAlign.Center
                    )
                }

                Spacer(modifier = Modifier.height(35.dp))

            }
        }
        Image(painter = painterResource(id = R.drawable.angel), contentDescription = "",
            alpha = 0.2f)
    }
}

@Composable
fun ResultLine(result: UserPhilosophy) {
    Row(
        Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        val date = getDate(result.time)

        Text(
            text = date,
            color = Color(0xFF707070),
            fontSize = 20.sp,
            fontFamily = FontFamily(Font(resId = R.font.ledger_regular)),
            textAlign = TextAlign.Center
        )

        Text(
            text = result.username,
            color = Color(0xFF707070),
            fontSize = 20.sp,
            fontFamily = FontFamily(Font(resId = R.font.ledger_regular)),
            textAlign = TextAlign.Center
        )

        Button(
            colors = ButtonDefaults.buttonColors(Color(0xFFFFEBE3)),
            onClick = { }
        ) {
            Image(painter = painterResource(id = R.drawable.search), contentDescription = "")
        }
    }
}

fun getDate(millis: Long): String {
    val formatter = SimpleDateFormat("dd/MM/yyyy", Locale.UK)
    return formatter.format(Date(millis))
}
