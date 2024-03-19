package ru.etu.dylema.domain

import ru.etu.dylema.domain.base_dilemma.DilemmaResult

fun createTextForShare(result: DilemmaResult): String {
    return """
        Я успешно завершил прохождение теста '${result.dilemmaType.title}'!
        
        Он показал, что моей этической школой является ${result.ethic.title}. 
        Вот мои подробные результаты:
            | ${result.dilemmaType.component1name}: ${result.state.component1}
            | ${result.dilemmaType.component2name}: ${result.state.component2}
            | ${result.dilemmaType.component3name}: ${result.state.component3}
        
        Попробуй и ты, чтобы мы могли сравнить свои результаты!
        <Ссылка на Google Play>
                      _
                     | |
                     | |===( )   //////
                     |_|   |||  | o o|
                            ||| ( c  )                  ____
                             ||| \= /                  ||   \_
                              ||||||                   ||     |
                              ||||||                ...||__/|-"
                              ||||||             __|________|__
                                |||             |______________|
                                |||             || ||      || ||
                                |||             || ||      || ||
        ------------------------|||-------------||-||------||-||-------
                                |__>            || ||      || ||
        
        
             hit any key to continue
    """.trimIndent()
}