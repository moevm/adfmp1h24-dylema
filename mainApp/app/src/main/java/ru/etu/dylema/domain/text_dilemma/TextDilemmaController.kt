package ru.etu.dylema.domain.text_dilemma

import ru.etu.dylema.R
import ru.etu.dylema.domain.DilemmaType
import ru.etu.dylema.domain.Ethic
import ru.etu.dylema.domain.base_dilemma.DilemmaController
import ru.etu.dylema.domain.base_dilemma.DilemmaPart
import ru.etu.dylema.domain.base_dilemma.DilemmaProvider
import ru.etu.dylema.domain.base_dilemma.DilemmaState
import java.io.File

class TextDilemmaController(filesDir: File) : DilemmaController(
    provider = DilemmaProvider(listOf(
        DilemmaPart(
            text = "Lod umn perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab.",
            imageId = R.drawable.man_sculpture,
            leftSolution = DilemmaState(component1 = 25),
            rightSolution = DilemmaState(component2 = 25)
        ),
        DilemmaPart(
            text = "Кто...",
            imageId = R.drawable.man_sculpture,
            leftSolution = DilemmaState(component1 = 25),
            rightSolution = DilemmaState(component2 = 25)
        ),
        DilemmaPart(
            text = "Никто. Lorem 8",
            imageId = R.drawable.man_sculpture,
            leftSolution = DilemmaState(component2 = 25),
            rightSolution = DilemmaState(component3 = 25)
        )
    )),
    type = DilemmaType.TEXT_DILEMMA, filesDir
) {
    // TODO: create other variants of ethics for text dilemma
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