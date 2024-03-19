package ru.etu.dylema.domain.text_dilemma

class TextDilemmaProvider() {

    private val textDilemmaParts = arrayListOf(
        TextDilemmaPart("Lod umn perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab.", TextDilemmaSolution(lib = 25), TextDilemmaSolution(ut = 25)),
        TextDilemmaPart("Кто...", TextDilemmaSolution(lib = 25), TextDilemmaSolution(ut = 25)),
        TextDilemmaPart("Никто. Lorem 8", TextDilemmaSolution(ut = 25), TextDilemmaSolution(self = 105), true)
    );

    private var pointer = 0;

    fun next(): TextDilemmaPart {
        if (pointer == (textDilemmaParts.size - 1)) {
            return textDilemmaParts[pointer]
        }

        return textDilemmaParts[++pointer]
    }

    fun prev(): TextDilemmaPart {
        if (pointer <= 0) {
            return textDilemmaParts[pointer]
        }

        return textDilemmaParts[--pointer]
    }

    fun current(): TextDilemmaPart {
        return textDilemmaParts[pointer]
    }

    fun currentNumber(): Int {
        return pointer + 1;
    }

    fun totalCount(): Int {
        return textDilemmaParts.size;
    }

}
