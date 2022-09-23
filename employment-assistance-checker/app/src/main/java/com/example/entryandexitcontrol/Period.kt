package com.example.entryandexitcontrol

import java.time.LocalDate

data class Period(
    val initialDate: LocalDate,
    val finalDate: LocalDate,
    val description: String
)