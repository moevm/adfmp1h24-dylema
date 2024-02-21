package ru.etu.dylema.domain

class UserPhilosophy {

    var libLevel: Int = 50
    var utLevel: Int = 50
    var selfLevel: Int = 50

    fun accept(solution: DilemmaSolution) {
        libLevel += solution.lib
        utLevel += solution.ut
        selfLevel += solution.self
    }

    fun reset() {
        this.libLevel = 50
        this.utLevel = 50
        this.selfLevel = 50
    }
}
