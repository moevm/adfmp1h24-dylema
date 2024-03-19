package ru.etu.dylema.domain.trolley_dilemma

import ru.etu.dylema.R
import ru.etu.dylema.domain.DilemmaType
import ru.etu.dylema.domain.Ethic
import ru.etu.dylema.domain.base_dilemma.DilemmaController
import ru.etu.dylema.domain.base_dilemma.DilemmaPart
import ru.etu.dylema.domain.base_dilemma.DilemmaProvider
import ru.etu.dylema.domain.base_dilemma.DilemmaState
import java.io.File

class TrolleyDilemmaController(filesDir: File) : DilemmaController(
    provider = DilemmaProvider(listOf(
        DilemmaPart(
            text = "Some very important question",
            imageId = R.drawable.img,
            leftSolution = DilemmaState(component1 = 25),
            rightSolution = DilemmaState(component2 = 25)
        ),
        DilemmaPart(
            text = "Why do you skip it?",
            imageId = R.drawable.ic_launcher_background,
            leftSolution = DilemmaState(component1 = 25),
            rightSolution = DilemmaState(component2 = 25)
        ),
        DilemmaPart(
            text = "STOP!",
            imageId = R.drawable.ic_launcher_foreground,
            leftSolution = DilemmaState(component2 = 25),
            rightSolution = DilemmaState(component3 = 25)
        )
    )),
    type = DilemmaType.TROLLEY_DILEMMA, filesDir
) {
    override fun getResultEthic(): Ethic {
        if (state.component1 >= state.component2) {
            if (state.component3 > state.component1) {
                return Ethic.EGOISM
            }
            return Ethic.LIBERTARIANISM
        } else {
            if (state.component3 > state.component2) {
                return Ethic.EGOISM
            }
            return Ethic.UTILITARIANISM
        }
    }
}