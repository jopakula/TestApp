package com.example.testapp.data.storage

import com.example.testapp.data.models.Question


val questions = listOf(
    Question(
        id = 1,
        questionText = "Что такое личный бюджет?",
        options = listOf("Набор кредитных карточек", "Запланированные доходы и расходы в установленный период", "Общее количество денег в банке"),
        correctAnswerIndex = 1
    ),
    Question(
        id = 2,
        questionText = "Что означает SMART при постановке финансовой цели?",
        options = listOf("Секретная, мистическая, абстрактная, рискованная, теоретическая", "Специфическая, измеримая, достижимая, релевантная, ограниченная во времени", "Стремительная, маневренная, адаптируемая, реалистичная, термальная"),
        correctAnswerIndex = 1
    ),
    Question(
        id = 3,
        questionText = "Как можно определить избыточные расходы?",
        options = listOf("Постоянно увеличивать доходы", "Сравнивать ваши доходы и расходы", " Увеличивать часть расходов"),
        correctAnswerIndex = 1
    ),
    Question(
        id = 4,
        questionText = "Для чего создается экстренный фонд?",
        options = listOf("Для инвестирования в акции", "Для покрытия непредвиденных расходов", "Для крупной покупки"),
        correctAnswerIndex = 1
    ),
    Question(
        id = 5,
        questionText = "Какой долг следует погашать в первую очередь по методу \"лавина\"?",
        options = listOf("С наименьшей общей суммой ", "С наибольшей процентной ставкой", "С самым длинным сроком"),
        correctAnswerIndex = 1
    ),
    Question(
        id = 6,
        questionText = "Что такое инвестиция?",
        options = listOf("Покупка товаров на распродажах", "Вклад средств с целью получения дохода", "Использование кредита для покупок"),
        correctAnswerIndex = 1
    ),
)