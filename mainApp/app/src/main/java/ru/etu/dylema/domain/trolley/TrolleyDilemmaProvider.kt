package ru.etu.dylema.domain.trolley

import ru.etu.dylema.R
import ru.etu.dylema.domain.DilemmaSolution

class TrolleyDilemmaProvider() {

    private val trolleyDilemmas = arrayListOf<TrolleyDilemma>(
        TrolleyDilemma(R.drawable.img, DilemmaSolution(lib = 25), DilemmaSolution(ut = 25)),
        TrolleyDilemma(R.drawable.ic_launcher_background, DilemmaSolution(lib = 25), DilemmaSolution(ut = 25)),
        TrolleyDilemma(R.drawable.ic_launcher_foreground, DilemmaSolution(ut = 25), DilemmaSolution(self = 25), true)
    );

    private var pointer = 0;

    fun next(): TrolleyDilemma {
        if (pointer == (trolleyDilemmas.size - 1)) {
            return trolleyDilemmas[pointer]
        }

        return trolleyDilemmas[++pointer]
    }

    fun prev(): TrolleyDilemma {
        if (pointer <= 0) {
            return trolleyDilemmas[pointer]
        }

        return trolleyDilemmas[--pointer]
    }

    fun current(): TrolleyDilemma {
        return trolleyDilemmas[pointer]
    }

    fun currentNumber(): Int {
        return pointer + 1;
    }

    fun totalCount(): Int {
        return trolleyDilemmas.size;
    }

}
