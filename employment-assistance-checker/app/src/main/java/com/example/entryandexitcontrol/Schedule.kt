import android.os.Build
import androidx.annotation.RequiresApi
import edu.itvo.checkinout.Employee
import java.time.DayOfWeek
import java.time.LocalTime
import java.time.Period


class Schedule private  constructor (private val details: ArrayList<Detail>) {

    data class Builder(
        val employee: Employee,
        val period: com.example.entryandexitcontrol.Period
    ) {

        private val details= ArrayList<Detail>()

        fun addOne(scheduleDetail: Detail): Builder {
            details.add(scheduleDetail)
            return this
        }
        fun addMany(scheduleDetails: ArrayList<Detail>): Builder {
            details.addAll(scheduleDetails)
            return this
        }

        fun build()= Schedule (details)
    }
    class Detail(
        val dayOfWeek: DayOfWeek,
        val checkIn: LocalTime,
        val checkOut: LocalTime
    ){
        override fun toString(): String {
            return "{\"dayOfWeek\":\"$dayOfWeek\"," +
                    "\"checkIn\":\"$checkIn\",\"checkOut\":\"$checkOut\"}"
        }
    }
    fun getDetails() = details
    @RequiresApi(Build.VERSION_CODES.N)
    fun deleteOne(dayOfWeek: DayOfWeek){
        details.removeIf{it.dayOfWeek==dayOfWeek}
    }
    @RequiresApi(Build.VERSION_CODES.N)
    fun deleteAll(){
        details.clear()
    }
}