package ru.etu.dylema.domain.dilemma

import ru.etu.dylema.domain.DilemmaSolution

data class Dilemma(val text: String, val leftSolution: DilemmaSolution, val rightSolution: DilemmaSolution, val isFinal: Boolean = false) {

}
