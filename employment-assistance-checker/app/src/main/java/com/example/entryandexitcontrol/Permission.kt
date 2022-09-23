package com.example.entryandexitcontrol


import edu.itvo.checkinout.Employee
import java.time.LocalDate

data class Permission (val employee: Employee,
                       val date: LocalDate,
                       val justification: String,
)
