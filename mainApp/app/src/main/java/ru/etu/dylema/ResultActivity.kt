package ru.etu.dylema

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.navigation.NavController
import ru.etu.dylema.domain.UserPhilosophy

@Composable
fun ResultScreen(navController: NavController, philosophy: MutableState<UserPhilosophy>) {

    Text(text = philosophy.value.libLevel.toString())
}
