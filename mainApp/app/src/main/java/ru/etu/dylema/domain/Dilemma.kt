package ru.etu.dylema.domain

data class Dilemma(val imageId: Int, val leftSolution: DilemmaSolution, val rightSolution: DilemmaSolution, val isFinal: Boolean = false) {

}
