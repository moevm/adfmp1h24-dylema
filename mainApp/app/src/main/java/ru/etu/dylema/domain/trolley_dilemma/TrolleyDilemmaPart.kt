package ru.etu.dylema.domain.trolley_dilemma

import ru.etu.dylema.domain.text_dilemma.TextDilemmaSolution

data class TrolleyDilemmaPart(
    val imageId: Int,
    val leftSolution: TextDilemmaSolution,
    val rightSolution: TextDilemmaSolution,
    val isFinal: Boolean = false
) {

}
