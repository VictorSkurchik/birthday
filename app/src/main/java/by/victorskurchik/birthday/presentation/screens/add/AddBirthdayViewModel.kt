package by.victorskurchik.birthday.presentation.screens.add

import android.app.AlarmManager
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import by.victorskurchik.birthday.domain.BirthdayRepository
import by.victorskurchik.birthday.domain.entities.Birthday
import by.victorskurchik.birthday.toDate
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject


@HiltViewModel
class AddBirthdayViewModel @Inject constructor(
    private val birthdayRepository: BirthdayRepository,
    private val alarmManager: AlarmManager
) : ViewModel() {

    fun addBirthday(birthday: Birthday) {
        viewModelScope.launch {
            birthdayRepository.addOrUpdateBirthday(birthday)
            setAlarm(birthday.date)
        }
    }

    private fun setAlarm(date: String) {
        val mDate = date.toDate()
        val calendar: Calendar = Calendar.getInstance()
        calendar.set(Calendar.HOUR_OF_DAY, 19)
        calendar.set(Calendar.MINUTE, 37)
        calendar.set(Calendar.DAY_OF_MONTH, mDate.day)
        calendar.set(Calendar.MONTH, mDate.month)
        TODO()
    }
}