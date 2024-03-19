package ru.etu.dylema.domain.trolley_dilemma

import ru.etu.dylema.R
import ru.etu.dylema.domain.text_dilemma.TextDilemmaSolution

class TrolleyDilemmaProvider() {

    private val trolleyDilemmaParts = arrayListOf(
        TrolleyDilemmaPart(R.drawable.img, TextDilemmaSolution(lib = 25), TextDilemmaSolution(ut = 25)),
        TrolleyDilemmaPart(R.drawable.ic_launcher_background, TextDilemmaSolution(lib = 25), TextDilemmaSolution(ut = 25)),
        TrolleyDilemmaPart(R.drawable.ic_launcher_foreground, TextDilemmaSolution(ut = 25), TextDilemmaSolution(self = 25), true)
    );

    private var pointer = 0;

    fun next(): TrolleyDilemmaPart {
        if (pointer == (trolleyDilemmaParts.size - 1)) {
            return trolleyDilemmaParts[pointer]
        }
        pointer++
        return trolleyDilemmaParts[pointer]
    }

    fun prev(): TrolleyDilemmaPart {
        if (pointer <= 0) {
            return trolleyDilemmaParts[pointer]
        }
        pointer--
        return trolleyDilemmaParts[pointer]
    }

    fun current(): TrolleyDilemmaPart {
        return trolleyDilemmaParts[pointer]
    }

    fun currentNumber(): Int {
        return pointer + 1;
    }

    fun totalCount(): Int {
        return trolleyDilemmaParts.size;
    }

}
