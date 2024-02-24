package ru.etu.dylema.domain.dilemma

import ru.etu.dylema.domain.DilemmaSolution

class TextDilemmaProvider() {

    private val dilemmas = arrayListOf<Dilemma>(
        Dilemma("Lod umn perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab.", DilemmaSolution(lib = 25), DilemmaSolution(ut = 25)),
        Dilemma("Кто...", DilemmaSolution(lib = 25), DilemmaSolution(ut = 25)),
        Dilemma("Никто. Lorem 8", DilemmaSolution(ut = 25), DilemmaSolution(self = 105), true)
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
