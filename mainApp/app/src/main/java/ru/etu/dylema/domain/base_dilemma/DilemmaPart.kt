package ru.etu.dylema.domain.base_dilemma


data class DilemmaPart(
    val text: String,
    val imageId: Int,
    val leftSolution: DilemmaState,
    val rightSolution: DilemmaState
)
