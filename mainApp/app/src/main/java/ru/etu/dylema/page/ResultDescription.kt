package ru.etu.dylema.page

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
import kotlinx.serialization.json.Json
import ru.etu.dylema.R
import ru.etu.dylema.domain.Ethic
import ru.etu.dylema.domain.UserPhilosophy
import java.io.File

@Composable
fun ResultDescription(time: Long, navController: NavController, filesDir: File) {

    val resultFile = File(filesDir, "user-results.json")
    if (!resultFile.exists()) {
        resultFile.writeText("[]")
    }

    val philosophies =
        Json.decodeFromString<List<UserPhilosophy>>(
            resultFile.readText()
        )

    /*val philosophy = remember {
        mutableStateOf(UserPhilosophy(time = 0))
    }

    philosophy.value.testName = "Вагонетка"

    val philosophies = listOf(philosophy.value)*/

    val philosophyOpt = philosophies.stream().filter{x -> x.time == time}.findAny()

    Box(
        Modifier
            .fillMaxSize()
            .background(Color(0xFFFFEBE3)),
        Alignment.BottomEnd
    ) {
        TextButton(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset((20).dp, 30.dp)
                .size(width = 35.dp, height = 35.dp),
            shape = RectangleShape,
            contentPadding = PaddingValues(),
            onClick = {
                navController.popBackStack()
            }
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
            text = "Обзор",
            color = Color(0xFF707070),
            fontSize = 23.sp,
            fontFamily = FontFamily(Font(resId = R.font.ledger_regular)),
            textAlign = TextAlign.Center
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp, 70.dp, 20.dp, 30.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            if (!philosophyOpt.isPresent) {
                Column(
                    modifier = Modifier
                        .weight(100f)
                        .padding(0.dp, 0.dp, 0.dp, 70.dp)
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        modifier = Modifier,
                        text = "Не удалось найти результат!",
                        color = Color(0xFF707070),
                        fontSize = 35.sp,
                        lineHeight = 35.sp,
                        fontFamily = FontFamily(Font(resId = R.font.ledger_regular)),
                        textAlign = TextAlign.Center
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    Button(
                        modifier = Modifier
                            .fillMaxWidth(0.9f),
                        colors = ButtonDefaults.buttonColors(Color(0xFFF4E0D9)),
                        shape = RectangleShape,
                        border = BorderStroke(1.dp, Color(0xFF707070)),
                        contentPadding = PaddingValues(0.dp, 0.dp, 0.dp, 8.dp),
                        onClick = { navController.navigate("main_screen") }

                    ) {
                        Text(
                            text = "Вернуться в главное меню",
                            color = Color(0xFF707070),
                            fontSize = 32.sp,
                            lineHeight = 32.sp,
                            fontFamily = FontFamily(Font(resId = R.font.ledger_regular)),
                            textAlign = TextAlign.Center
                        )
                    }
                }
            } else {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(0.dp, 20.dp),
                    verticalAlignment = Alignment.Top,
                    horizontalArrangement = Arrangement.Center
                ) {
                    when (philosophyOpt.get().getEthic()) {
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
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.SpaceBetween,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Результаты " + philosophyOpt.get().username,
                        color = Color(0xFF707070),
                        fontSize = 24.sp,
                        fontFamily = FontFamily(Font(resId = R.font.ledger_regular)),
                        textAlign = TextAlign.Center,
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    // TODO: Maybe shift this part to dilemma files since every dilemma has different results...
                    Text(
                        text = Ethic.LIBERTARIANISM.title + ": " + philosophyOpt.get().libLevel,
                        color = Color(0xFF707070),
                        fontSize = 20.sp,
                        fontFamily = FontFamily(Font(resId = R.font.ledger_regular)),
                        textAlign = TextAlign.Start,
                    )
                    Text(
                        text = Ethic.UTILITARIANISM.title + ": " + philosophyOpt.get().utLevel,
                        color = Color(0xFF707070),
                        fontSize = 20.sp,
                        fontFamily = FontFamily(Font(resId = R.font.ledger_regular)),
                        textAlign = TextAlign.Start,
                    )
                    Text(
                        text = Ethic.EGOISM.title + ": " + philosophyOpt.get().selfLevel,
                        color = Color(0xFF707070),
                        fontSize = 20.sp,
                        fontFamily = FontFamily(Font(resId = R.font.ledger_regular)),
                        textAlign = TextAlign.Start,
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Этика: " + philosophyOpt.get().getEthic().toString(),
                        color = Color(0xFF707070),
                        fontSize = 24.sp,
                        fontFamily = FontFamily(Font(resId = R.font.ledger_regular)),
                        textAlign = TextAlign.Center,
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(2.dp)
                            .border(BorderStroke(2.dp, Color(0xFF707070)))
                    ){}
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Когда волк волк, а другой волк не волк, то волк не волку волк, а не волк не волк, ведь он не волк, а когда волк не волк, он не волк, не волк никому не волк, только волк всем волк, даже не волку волк волк, если не волк волку не волк.\n" +
                                "\n" +
                                "Ещё один абзац таких же умных мыслей, который подытоживает вышесказанное и раскрывает читателю его мировоззрение.",
                        color = Color(0xFF707070),
                        fontSize = 20.sp,
                        fontFamily = FontFamily(Font(resId = R.font.ledger_regular)),
                        textAlign = TextAlign.Center,
                    )
                }
            }

        }
        Image(
            painter = painterResource(id = R.drawable.angel), contentDescription = "",
            alpha = 0.2f
        )
    }

}


@Preview(
    showBackground = true,
    widthDp = 390,
    heightDp = 844
)
@Composable
fun EthicIntroductionPreview() {
    val navController = rememberNavController()
    ResultDescription(
        0,
        navController,
        File("")
    )
}