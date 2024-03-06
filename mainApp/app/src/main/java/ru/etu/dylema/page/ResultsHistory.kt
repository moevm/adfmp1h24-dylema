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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
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
import kotlinx.serialization.json.Json
import ru.etu.dylema.R
import ru.etu.dylema.domain.UserPhilosophy
import java.io.File
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun TotalResultScreen(navController: NavController, filesDir: File) {
    val openDeleteConfirmationDialog = remember {
        mutableStateOf(false)
    }

    val openShareDialog = remember {
        mutableStateOf(false)
    }
    val resultToShare = remember {
        mutableStateOf(UserPhilosophy(time = 0))
    }

    val resultFile = File(filesDir, "user-results.json")
    if (!resultFile.exists()) {
        resultFile.writeText("[]")
    }

    val results = remember {
        mutableStateOf(
            Json.decodeFromString<List<UserPhilosophy>>(
                resultFile.readText()
            )
        )
    }

    /*val philosophy = remember {
        mutableStateOf(UserPhilosophy(time = 0))
    }

    philosophy.value.testName = "Вагонетка"

    val philosophy1 = remember {
        mutableStateOf(UserPhilosophy(time = 234553L))
    }

    philosophy1.value.testName = "Дилемма"


    val results = remember {
        mutableStateOf(listOf(philosophy.value, philosophy1.value, philosophy.value, philosophy1.value))
    }*/

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFEBE3)),
        contentAlignment = Alignment.BottomEnd
    ) {

        if (openShareDialog.value) {
            Dialog(onDismissRequest = {
                openShareDialog.value = false;
            }) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth(0.9f)
                        .background(Color(0xFFFFEBE3)),
                    contentAlignment = Alignment.TopCenter
                ) {
                    TextButton(
                        modifier = Modifier
                            .align(Alignment.TopStart)
                            .offset((20).dp, 20.dp)
                            .size(width = 35.dp, height = 35.dp),
                        shape = RectangleShape,
                        contentPadding = PaddingValues(),
                        onClick = {
                            openShareDialog.value = false
                        }
                    ) {
                        Icon(
                            modifier = Modifier.size(35.dp),
                            imageVector = Icons.Outlined.ArrowBack,
                            contentDescription = "Back button",
                            tint = Color(0xFF000000)
                        )
                    }
                    Column(
                        modifier = Modifier
                            .padding(0.dp, 20.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Text(
                            modifier = Modifier.padding(0.dp, 20.dp),
                            text = "Поделиться",
                            color = Color(0xFF707070),
                            fontSize = 24.sp,
                            fontFamily = FontFamily(Font(resId = R.font.ledger_regular)),
                            textAlign = TextAlign.Center
                        )
                        Column(
                            modifier = Modifier
                                .fillMaxWidth(0.8f)
                                .height(1.dp)
                                .border(BorderStroke(1.dp, Color(0xFF707070)))
                        ){}
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(55.dp, 20.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                        ){
                            TextButton(
                                modifier = Modifier
                                    .size(40.dp),
                                shape = RectangleShape,
                                contentPadding = PaddingValues(),
                                onClick = {
                                    // TODO: implement "Share" buttons logic
                                }
                            ) {
                                Image(
                                    modifier = Modifier
                                        .size(40.dp),
                                    painter = painterResource(id = R.drawable.vk_logo),
                                    contentDescription = "",
                                )
                            }
                            TextButton(
                                modifier = Modifier
                                    .size(40.dp),
                                shape = RectangleShape,
                                contentPadding = PaddingValues(),
                                onClick = {
                                    // TODO: implement "Share" buttons logic
                                }
                            ) {
                                Image(
                                    modifier = Modifier
                                        .size(40.dp),
                                    painter = painterResource(id = R.drawable.telegram_logo),
                                    contentDescription = "",
                                )
                            }
                            TextButton(
                                modifier = Modifier
                                    .size(40.dp),
                                shape = RectangleShape,
                                contentPadding = PaddingValues(),
                                onClick = {
                                    // TODO: implement "Share" buttons logic
                                }
                            ) {
                                Image(
                                    modifier = Modifier
                                        .size(40.dp),
                                    painter = painterResource(id = R.drawable.whatsapp_logo),
                                    contentDescription = "",
                                )
                            }
                        }
                    }
                }
            }
        }

        if (openDeleteConfirmationDialog.value) {
            Dialog(onDismissRequest = {
                openDeleteConfirmationDialog.value = false;
            }) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth(1f)
                        .background(Color(0xFFFFEBE3)),
                    contentAlignment = Alignment.TopCenter
                ) {
                    TextButton(
                        modifier = Modifier
                            .align(Alignment.TopStart)
                            .offset((20).dp, 20.dp)
                            .size(width = 35.dp, height = 35.dp),
                        shape = RectangleShape,
                        contentPadding = PaddingValues(),
                        onClick = {
                            openDeleteConfirmationDialog.value = false
                        }
                    ) {
                        Icon(
                            modifier = Modifier.size(35.dp),
                            imageVector = Icons.Outlined.ArrowBack,
                            contentDescription = "Back button",
                            tint = Color(0xFF000000)
                        )
                    }
                    Column(
                        modifier = Modifier
                            .padding(0.dp, 40.dp, 0.dp, 20.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Text(
                            modifier = Modifier.padding(0.dp, 20.dp, 0.dp, 0.dp),
                            text = "Удалить все результаты?",
                            color = Color(0xFF707070),
                            fontSize = 20.sp,
                            fontFamily = FontFamily(Font(resId = R.font.ledger_regular)),
                            textAlign = TextAlign.Center
                        )
                        Text(
                            modifier = Modifier.padding(0.dp, 20.dp),
                            text = "Это действие нельзя отменить.",
                            color = Color(0xFF707070),
                            fontSize = 24.sp,
                            fontFamily = FontFamily(Font(resId = R.font.ledger_regular)),
                            textAlign = TextAlign.Center
                        )
                        Column(
                            modifier = Modifier
                                .fillMaxWidth(0.8f)
                                .height(1.dp)
                                .border(BorderStroke(1.dp, Color(0xFF707070)))
                        ){}
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(55.dp, 20.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                        ){
                            Button(
                                colors = ButtonDefaults.buttonColors(Color(0xFFF4E0D9)),
                                shape = RectangleShape,
                                border = BorderStroke(1.dp, Color(0xFF707070)),
                                contentPadding = PaddingValues(10.dp, 10.dp),
                                onClick = {
                                    openDeleteConfirmationDialog.value = false
                                    resultFile.writeText("[]")
                                    navController.navigate("main_screen")
                                }
                            ) {
                                Text(
                                    text = "Да",
                                    color = Color(0xFF707070),
                                    fontSize = 24.sp,
                                    lineHeight = 24.sp,
                                    fontFamily = FontFamily(Font(resId = R.font.ledger_regular)),
                                    textAlign = TextAlign.Center
                                )
                            }
                            Button(
                                colors = ButtonDefaults.buttonColors(Color(0xFFF4E0D9)),
                                shape = RectangleShape,
                                border = BorderStroke(1.dp, Color(0xFF707070)),
                                contentPadding = PaddingValues(10.dp, 10.dp),
                                onClick = { openDeleteConfirmationDialog.value = false }
                            ) {
                                Text(
                                    text = "Нет",
                                    color = Color(0xFF707070),
                                    fontSize = 24.sp,
                                    lineHeight = 24.sp,
                                    fontFamily = FontFamily(Font(resId = R.font.ledger_regular)),
                                    textAlign = TextAlign.Center
                                )
                            }
                        }
                    }
                }
            }
        }

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
                .offset(0.dp, 30.dp),
            text = "Все результаты",
            color = Color(0xFF707070),
            fontSize = 22.sp,
            fontFamily = FontFamily(Font(resId = R.font.ledger_regular)),
            textAlign = TextAlign.Center
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(0.dp, 70.dp, 0.dp, 0.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {


            val uniqueTasks: MutableMap<String, MutableList<UserPhilosophy>> = HashMap()
            for (r in results.value) {
                if (r.testName !in uniqueTasks.keys) {
                    uniqueTasks[r.testName] = ArrayList()
                }
                uniqueTasks[r.testName]!!.add(r)
            }

            for (test in uniqueTasks.entries) {
                ResultBlock(test.key, test.value, navController, resultToShare, openShareDialog)
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
                        openDeleteConfirmationDialog.value = true
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
        Image(
            painter = painterResource(id = R.drawable.angel), contentDescription = "",
            alpha = 0.2f
        )
    }
}

@Composable
fun ResultBlock(testName: String, results: MutableList<UserPhilosophy>, navController: NavController, resultToShare: MutableState<UserPhilosophy>, openShareDialog: MutableState<Boolean>, modifier: Modifier = Modifier) {

    Column(
        modifier = modifier
            .padding(10.dp, 10.dp)
            .border(BorderStroke(3.dp, Color(0xFF707070)))

    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .padding(10.dp, 10.dp),
            text = testName,
            color = Color(0xFF707070),
            fontSize = 24.sp,
            fontFamily = FontFamily(Font(resId = R.font.ledger_regular)),
            textAlign = TextAlign.Left
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(3.dp)
                .border(BorderStroke(3.dp, Color(0xFF707070)))
        ){}

        val sortedResults = results.sortedByDescending { it.time }
        for (i in 1..sortedResults.size) {
            ResultLine(result = sortedResults[i - 1], navController, resultToShare, openShareDialog)

            if (i != sortedResults.size) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(1.dp)
                        .border(BorderStroke(1.dp, Color(0xFF707070)))
                ){}
            }


        }
    }
}

@Composable
fun ResultLine(result: UserPhilosophy, navController: NavController?, resultToShare: MutableState<UserPhilosophy>, openShareDialog: MutableState<Boolean>) {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(10.dp, 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
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

        Row() {
            Button(
                modifier = Modifier
                    .size(width = 30.dp, height = 30.dp),
            colors = ButtonDefaults.buttonColors(Color(0xFFFFEBE3)),
                contentPadding = PaddingValues(0.dp, 0.dp, 2.dp, 0.dp),
                onClick = {
                    resultToShare.value = result
                    openShareDialog.value = true
                }
            ) {
                Icon(
                    modifier = Modifier.size(20.dp),
                    imageVector = Icons.Outlined.Share,
                    contentDescription = "Share button",
                    tint = Color(0xFF000000)
                )
            }

            Spacer(modifier = Modifier.width(5.dp))

            Button(
                modifier = Modifier
                    .size(width = 30.dp, height = 30.dp),
            colors = ButtonDefaults.buttonColors(Color(0xFFFFEBE3)),
                contentPadding = PaddingValues(),
                onClick = {
                    navController?.navigate("ethic_intro_screen?time=" + result.time)
                }
            ) {
                Icon(
                    modifier = Modifier.size(20.dp),
                    imageVector = Icons.Outlined.Search,
                    contentDescription = "Search button",
                    tint = Color(0xFF000000)
                )
//                Image(painter = painterResource(id = R.drawable.search), contentDescription = "")
            }



        }

    }
}

fun getDate(millis: Long): String {
    val formatter = SimpleDateFormat("dd/MM/yyyy", Locale.UK)
    return formatter.format(Date(millis))
}

@Preview(
    showBackground = true,
    widthDp = 390,
    heightDp = 844
)
@Composable
fun TotalResultPreview() {
    val navController = rememberNavController()
    TotalResultScreen(
        navController,
        File("")
    )
}