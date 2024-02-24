package ru.etu.dylema.domain.trolley

import ru.etu.dylema.domain.DilemmaSolution

data class TrolleyDilemma(val imageId: Int, val leftSolution: DilemmaSolution, val rightSolution: DilemmaSolution, val isFinal: Boolean = false) {

}
