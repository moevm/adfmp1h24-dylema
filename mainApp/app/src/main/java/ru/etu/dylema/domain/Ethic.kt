package ru.etu.dylema.domain

enum class Ethic(var title: String) {
    LIBERTARIANISM("Либертарианство"),
    UTILITARIANISM("Утилитаризм"),
    EGOISM("Разумный эгоизм");

    override fun toString(): String {
        return title
    }
}
