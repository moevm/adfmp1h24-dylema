package ru.etu.dylema.domain

class UserPhilosophy {

    var libLevel: Int = 50
    var utLevel: Int = 50
    var selfLevel: Int = 50

    fun takeSolved(solution: DilemmaSolution) {
        libLevel += solution.lib
        utLevel += solution.ut
        selfLevel += solution.self
    }
}