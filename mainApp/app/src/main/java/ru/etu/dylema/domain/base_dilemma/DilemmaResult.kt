package ru.etu.dylema.domain.base_dilemma

import kotlinx.serialization.Serializable
import ru.etu.dylema.domain.DilemmaType
import ru.etu.dylema.domain.Ethic

@Serializable
data class DilemmaResult(
    val time: Long,
    val state: DilemmaState,
    val ethic: Ethic,
    val dilemmaType: DilemmaType
)