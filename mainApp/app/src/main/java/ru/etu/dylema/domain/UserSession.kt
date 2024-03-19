package ru.etu.dylema.domain

import ru.etu.dylema.domain.base_dilemma.DilemmaController
import ru.etu.dylema.domain.text_dilemma.TextDilemmaController
import ru.etu.dylema.domain.trolley_dilemma.TrolleyDilemmaController
import java.io.File

class UserSession(
    filesDir: File
) {
    val controllers: Map<DilemmaType, DilemmaController> = mapOf(
        Pair(DilemmaType.TEXT_DILEMMA, TextDilemmaController(filesDir)),
        Pair(DilemmaType.TROLLEY_DILEMMA, TrolleyDilemmaController(filesDir))
    );

    var currentDilemma: DilemmaType? = null

    fun reset() {
        for (controller: DilemmaController in controllers.values) {
            controller.reset()
        }
    }

}