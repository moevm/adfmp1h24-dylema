package ru.etu.dylema.domain

import kotlinx.serialization.Serializable

@Serializable
enum class DilemmaType(
    val title: String,
    val component1name: String,
    val component2name: String,
    val component3name: String,
) {
    TEXT_DILEMMA(
        title = "Дилемма",
        component1name = "Component 1",
        component2name = "Component 2",
        component3name = "Component 3"
    ),
    TROLLEY_DILEMMA(
        title = "Вагонетка",
        component1name = Ethic.LIBERTARIANISM.title,
        component2name = Ethic.UTILITARIANISM.title,
        component3name = Ethic.EGOISM.title
    );

    override fun toString(): String {
        return title
    }
}