package com.example.entryandexitcontrol

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDate

class Personal(val id:String,
               val fullName:String,
               val grade:String,
               val curp:String,
               val dateOfAdmission: LocalDate,
               val genre:String,
               val budgetKey:String){


    @RequiresApi(Build.VERSION_CODES.O)
    fun getSeniority():Int{
        return LocalDate.now().year - dateOfAdmission.year
    }
}