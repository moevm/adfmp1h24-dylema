package ru.etu.dylema.domain

import kotlinx.serialization.Serializable
import ru.etu.dylema.domain.text_dilemma.TextDilemmaSolution

@Serializable
class UserPhilosophy(var username: String = "user", val time: Long) {

    var libLevel: Int = 50
    var utLevel: Int = 50
    var selfLevel: Int = 50
    var testName = ""

    fun accept(solution: TextDilemmaSolution) {
        libLevel += solution.lib
        utLevel += solution.ut
        selfLevel += solution.self
    }

    fun reset() {
        this.libLevel = 50
        this.utLevel = 50
        this.selfLevel = 50
    }

    fun getEthic(): Ethic {
        if (libLevel >= utLevel) {
            if (selfLevel > libLevel) {
                return Ethic.EGOISM
            }
            return Ethic.LIBERTARIANISM
        } else {
            if (selfLevel > utLevel) {
                return Ethic.EGOISM
            }
            return Ethic.UTILITARIANISM
        }
    }
}
