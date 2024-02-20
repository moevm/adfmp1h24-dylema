package ru.etu.dylema

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ru.etu.dylema.domain.DilemmaProvider
import ru.etu.dylema.domain.UserPhilosophy

@Composable
fun DilemmaScreen(navController: NavController, philosophy: MutableState<UserPhilosophy>) {
    val dilemmaProvider = remember {
        mutableStateOf(DilemmaProvider())
    }
    val currentTask = remember {
        mutableStateOf(dilemmaProvider.value.current())
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.5f)
                .padding(0.dp, 20.dp),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = currentTask.value.imageId),
                contentDescription = "Andy Rubin",
                modifier = Modifier
                    .fillMaxSize()

            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Column {
                Button(onClick = {
                    val solution = currentTask.value.leftSolution
                    philosophy.value.takeSolved(solution)

                    if (currentTask.value.isFinal) {
                        navController.navigate("result_screen")
                    } else {
                        val task = dilemmaProvider.value.next()
                        currentTask.value = task
                    }
                }) {
                    Text(text = "Назад")
                }
            }
            Column {
                Button(onClick = {
                    val solution = currentTask.value.rightSolution
                    philosophy.value.takeSolved(solution)

                    if (currentTask.value.isFinal) {
                        navController.navigate("result_screen")
                    } else {
                        val task = dilemmaProvider.value.next()
                        currentTask.value = task
                    }
                }) {
                    Text(text = "Вперед")
                }
            }
        }
    }

}

