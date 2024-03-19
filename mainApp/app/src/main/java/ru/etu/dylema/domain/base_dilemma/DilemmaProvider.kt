package ru.etu.dylema.domain.base_dilemma

open class DilemmaProvider(
    private val dilemmaParts: List<DilemmaPart>
) {
    private var pointer = 0;

    fun next() {
        if (hasNext()) {
            pointer++
        }
    }

    fun hasNext(): Boolean {
        return pointer != (dilemmaParts.size - 1)
    }

    fun current(): DilemmaPart {
        return dilemmaParts[pointer]
    }

    fun reset() {
        pointer = 0
    }

    fun currentNumber(): Int {
        return pointer + 1;
    }

    fun totalCount(): Int {
        return dilemmaParts.size;
    }
}