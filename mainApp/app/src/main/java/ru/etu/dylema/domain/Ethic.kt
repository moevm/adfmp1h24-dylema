package ru.etu.dylema.domain

import kotlinx.serialization.Serializable
import ru.etu.dylema.R

@Serializable
enum class Ethic(
    val title: String,
    val imageId: Int
) {
    LIBERTARIANISM(
        title = "Либертарианство",
        imageId = R.drawable.libert
    ),
    UTILITARIANISM(
        title = "Утилитаризм",
        imageId = R.drawable.utilitarism
    ),
    EGOISM(
        title = "Разумный эгоизм",
        imageId = R.drawable.egoism
    );


}
