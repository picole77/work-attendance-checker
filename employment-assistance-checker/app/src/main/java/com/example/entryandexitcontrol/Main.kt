package com.example.entryandexitcontrol

import android.os.Build
import androidx.annotation.RequiresApi
import edu.itvo.checkinout.Employee
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.LocalTime


@RequiresApi(Build.VERSION_CODES.O)
fun main(){
    val employee = Employee(
        1,
        "Miguel Angel Pablo Martinez",
        AcademicLevel.ASSOCIATE,
        "PAMM840910HOCBRG09",
        LocalDate.parse("2004-10-10"),
        "PAMM8409102000"
    )

    var period = Period(
        LocalDate.parse("2009-09-02"),
        LocalDate.parse("2022-09-20"),
        "Periodo general"
    )

    val schedule = Schedule.Builder(employee,period).addMany(listDetails).build()

    val listOfCheckInOut = listOf<CheckInOut>(
        CheckInOut(
            LocalDate.parse("2022-09-12"),
            employee,
            LocalTime.parse("08:00"),
            LocalTime.parse("20:00")
        ),
        CheckInOut(
            LocalDate.parse("2022-09-13"),
            employee,
            LocalTime.parse("08:00"),
            LocalTime.parse("20:00")
        ),
        CheckInOut(
            LocalDate.parse("2022-09-14"),
            employee,
            LocalTime.parse("08:21"),
            LocalTime.parse("20:00")
        ),
        CheckInOut(
            LocalDate.parse("2022-09-15"),
            employee,
            LocalTime.parse("08:11"),
            LocalTime.parse("20:00")
        ),
        CheckInOut(
            LocalDate.parse("2022-09-16"),
            employee,
            LocalTime.parse("08:11"),
            LocalTime.parse("20:00")
        )
    )

    val incident = Incident(
        employee,
        schedule,
        listOfCheckInOut,
        listOf(),
        LocalDate.parse("2022-09-12"),
        LocalDate.parse("2022-09-16")
    )

    println("La antiguedad del empleado ${employee.fullName} es de: ${employee.getSeniority()} años")
    println("Faltas: ${incident.getAbsences()}")
    println("retardo: ${incident.getRetardant()}")
}

@RequiresApi(Build.VERSION_CODES.O)
var listDetails = arrayListOf<Schedule.Detail>(
    Schedule.Detail(
        DayOfWeek.MONDAY,
        LocalTime.parse("08:00"),
        LocalTime.parse("20:00")
    ),
    Schedule.Detail(
        DayOfWeek.TUESDAY,
        LocalTime.parse("08:00"),
        LocalTime.parse("20:00")
    ),
    Schedule.Detail(
        DayOfWeek.WEDNESDAY,
        LocalTime.parse("08:00"),
        LocalTime.parse("20:00")
    )
    ,
    Schedule.Detail(
        DayOfWeek.THURSDAY,
        LocalTime.parse("08:00"),
        LocalTime.parse("20:00")
    ),
    Schedule.Detail(
        DayOfWeek.FRIDAY,
        LocalTime.parse("08:00"),
        LocalTime.parse("20:00")
    )
)