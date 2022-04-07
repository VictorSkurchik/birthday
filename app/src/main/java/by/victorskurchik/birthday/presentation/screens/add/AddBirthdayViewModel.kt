package by.victorskurchik.birthday.presentation.screens.add

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import by.victorskurchik.birthday.domain.BirthdayRepository
import by.victorskurchik.birthday.domain.entities.Birthday
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddBirthdayViewModel @Inject constructor(
    private val birthdayRepository: BirthdayRepository
) : ViewModel() {

    fun addBirthday(birthday: Birthday) {
        viewModelScope.launch {
            birthdayRepository.addOrUpdateBirthday(birthday)
        }
    }
}