package ru.etu.dylema.domain

import ru.etu.dylema.R

class DilemmaProvider() {

    private val dilemmas = arrayListOf<Dilemma>(
        Dilemma(R.drawable.img, DilemmaSolution(lib = 25), DilemmaSolution(ut = 25)),
        Dilemma(R.drawable.ic_launcher_background, DilemmaSolution(lib = 25), DilemmaSolution(ut = 25)),
        Dilemma(R.drawable.ic_launcher_foreground, DilemmaSolution(ut = 25), DilemmaSolution(self = 25), true)
    );

    private var pointer = 0;

    fun next(): Dilemma {
        if (pointer == (dilemmas.size - 1)) {
            return dilemmas[pointer]
        }

        return dilemmas[++pointer]
    }

    fun prev(): Dilemma {
        if (pointer <= 0) {
            return dilemmas[pointer]
        }

        return dilemmas[--pointer]
    }

    fun current(): Dilemma {
        return dilemmas[pointer]
    }

    fun currentNumber(): Int {
        return pointer + 1;
    }

    fun totalCount(): Int {
        return dilemmas.size;
    }

}
