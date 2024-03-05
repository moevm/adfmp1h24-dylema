package ru.etu.dylema

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import ru.etu.dylema.domain.Ethic
import ru.etu.dylema.domain.UserPhilosophy
import java.io.File

@Composable
fun EthicIntroduction(time: Long, navController: NavController, filesDir: File) {

    // TODO: try with bigger description for scrolling testing

    val resultFile = File(filesDir, "user-results.json")
    if (!resultFile.exists()) {
        resultFile.writeText("[]")
    }

    val philosophies =
        Json.decodeFromString<List<UserPhilosophy>>(
            resultFile.readText()
        )

    val philosophy = philosophies.stream().filter{x -> x.time == time}.findAny().get()


    Box(
        Modifier.fillMaxSize(),
        Alignment.BottomEnd
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

                }

                Text(
                    text = "Обзор",
                    color = Color(0xFF707070),
                    fontSize = 20.sp,
                    fontFamily = FontFamily(Font(resId = R.font.ledger_regular)),
                    textAlign = TextAlign.Center
                )

                // TODO: add knowledge of previous screen! Must not always return to results list
                Button(
                    colors = ButtonDefaults.buttonColors(Color(0xFFFFEBE3)),
                    onClick = {
                        navController.navigate("total_result_screen")
                    }
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
                when (philosophy.getEthic()) {
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
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp, 0.dp, 0.dp, 0.dp),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Результаты " + philosophy.username,
                    color = Color(0xFF707070),
                    fontSize = 24.sp,
                    fontFamily = FontFamily(Font(resId = R.font.ledger_regular)),
                    textAlign = TextAlign.Center,
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = Ethic.LIBERTARIANISM.title + ": " + philosophy.libLevel,
                    color = Color(0xFF707070),
                    fontSize = 20.sp,
                    fontFamily = FontFamily(Font(resId = R.font.ledger_regular)),
                    textAlign = TextAlign.Start,
                )
                Text(
                    text = Ethic.UTILITARIANISM.title + ": " + philosophy.utLevel,
                    color = Color(0xFF707070),
                    fontSize = 20.sp,
                    fontFamily = FontFamily(Font(resId = R.font.ledger_regular)),
                    textAlign = TextAlign.Start,
                )
                Text(
                    text = Ethic.EGOISM.title + ": " + philosophy.selfLevel,
                    color = Color(0xFF707070),
                    fontSize = 20.sp,
                    fontFamily = FontFamily(Font(resId = R.font.ledger_regular)),
                    textAlign = TextAlign.Start,
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "Этика: " + philosophy.getEthic().toString(),
                    color = Color(0xFF707070),
                    fontSize = 24.sp,
                    fontFamily = FontFamily(Font(resId = R.font.ledger_regular)),
                    textAlign = TextAlign.Center,
                )
                Spacer(modifier = Modifier.height(10.dp))
                Image(
                    painter = painterResource(id = R.drawable.spacer), contentDescription = "",
                    Modifier
                        .fillMaxWidth()
                        .aspectRatio(ratio = 100f),
                    contentScale = ContentScale.Fit
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "Описание? Возможно, не нужно",
                    color = Color(0xFF707070),
                    fontSize = 20.sp,
                    fontFamily = FontFamily(Font(resId = R.font.ledger_regular)),
                    textAlign = TextAlign.Center,
                )
            }
        }
        Image(
            painter = painterResource(id = R.drawable.angel), contentDescription = "",
            alpha = 0.2f
        )
    }

}

@Preview(showBackground = true)
@Composable
fun EthicIntroductionPreview() {
    val philosophy = UserPhilosophy(time = 0)

    Box(
        Modifier.fillMaxSize(),
        Alignment.BottomEnd
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

                }

                Text(
                    text = "Обзор",
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
                    .padding(0.dp, 20.dp),
                verticalAlignment = Alignment.Top,
                horizontalArrangement = Arrangement.Center
            ) {
                when (philosophy.getEthic()) {
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
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp, 0.dp, 0.dp, 0.dp),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Результаты " + philosophy.username,
                    color = Color(0xFF707070),
                    fontSize = 24.sp,
                    fontFamily = FontFamily(Font(resId = R.font.ledger_regular)),
                    textAlign = TextAlign.Center,
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = Ethic.LIBERTARIANISM.title + ": " + philosophy.libLevel,
                    color = Color(0xFF707070),
                    fontSize = 20.sp,
                    fontFamily = FontFamily(Font(resId = R.font.ledger_regular)),
                    textAlign = TextAlign.Start,
                )
                Text(
                    text = Ethic.UTILITARIANISM.title + ": " + philosophy.utLevel,
                    color = Color(0xFF707070),
                    fontSize = 20.sp,
                    fontFamily = FontFamily(Font(resId = R.font.ledger_regular)),
                    textAlign = TextAlign.Start,
                )
                Text(
                    text = Ethic.EGOISM.title + ": " + philosophy.selfLevel,
                    color = Color(0xFF707070),
                    fontSize = 20.sp,
                    fontFamily = FontFamily(Font(resId = R.font.ledger_regular)),
                    textAlign = TextAlign.Start,
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "Этика: " + philosophy.getEthic().toString(),
                    color = Color(0xFF707070),
                    fontSize = 24.sp,
                    fontFamily = FontFamily(Font(resId = R.font.ledger_regular)),
                    textAlign = TextAlign.Center,
                )
                Spacer(modifier = Modifier.height(10.dp))
                Image(
                    painter = painterResource(id = R.drawable.spacer), contentDescription = "",
                    Modifier
                        .fillMaxWidth()
                        .aspectRatio(ratio = 100f),
                    contentScale = ContentScale.Fit
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "Описание? Возможно, не нужно",
                    color = Color(0xFF707070),
                    fontSize = 20.sp,
                    fontFamily = FontFamily(Font(resId = R.font.ledger_regular)),
                    textAlign = TextAlign.Center,
                )
            }
        }
        Image(
            painter = painterResource(id = R.drawable.angel), contentDescription = "",
            alpha = 0.2f
        )
    }
}