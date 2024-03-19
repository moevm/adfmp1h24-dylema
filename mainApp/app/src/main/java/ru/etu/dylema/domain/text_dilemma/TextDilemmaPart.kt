package ru.etu.dylema.domain.text_dilemma

data class TextDilemmaPart(
    val text: String,
    val leftSolution: TextDilemmaSolution,
    val rightSolution: TextDilemmaSolution,
    val isFinal: Boolean = false
)
