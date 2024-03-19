package ru.etu.dylema.domain.base_dilemma

import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import ru.etu.dylema.domain.DilemmaType
import ru.etu.dylema.domain.Ethic
import java.io.File

abstract class DilemmaController(
    val provider: DilemmaProvider,
    val type: DilemmaType,
    private val filesDir: File
) {
    protected val state: DilemmaState = DilemmaState()

    var initTime: Long = -1
        private set

    var hasFinished = false
        private set

    fun init() {
        reset()
        initTime = System.currentTimeMillis()
    }

    fun applyLeft():Boolean {
        state.applyChange(provider.current().leftSolution)
        hasFinished = !provider.hasNext()

        provider.next()

        return hasFinished
    }

    fun applyRight():Boolean {
        state.applyChange(provider.current().rightSolution)
        hasFinished = !provider.hasNext()

        provider.next()

        return hasFinished
    }

    fun reset() {
        state.reset()
        provider.reset()
    }

    fun current(): DilemmaPart {
        return provider.current()
    }

    fun currentNumber(): Int {
        return provider.currentNumber()
    }

    fun totalCount(): Int {
        return provider.totalCount()
    }

    fun saveResult() {
        if (filesDir.name.isBlank()) {
            return
        }

        val resultFile = File(filesDir, "user-results.json")

        val result = getResult()

        if (!resultFile.exists()) {
            resultFile.writeText("[]")
        }

        val results = Json.decodeFromString<ArrayList<DilemmaResult>>(resultFile.readText())
        results.add(result)

        resultFile.writeText(Json.encodeToString(results))
    }

    abstract fun getResultEthic(): Ethic

    fun getResult(): DilemmaResult {
        return DilemmaResult(
            time = initTime,
            state = state,
            ethic = getResultEthic(),
            dilemmaType = type
        )
    }

}