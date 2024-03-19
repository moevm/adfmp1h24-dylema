package ru.etu.dylema.domain.base_dilemma

import kotlinx.serialization.Serializable

@Serializable
class DilemmaState(
    var component1: Int = 0,
    var component2: Int = 0,
    var component3: Int = 0
) {

    fun applyChange(stateChange: DilemmaState) {
        component1 += stateChange.component1
        component2 += stateChange.component2
        component3 += stateChange.component3
    }

    fun reset() {
        component1 = 0
        component2 = 0
        component3 = 0
    }


}