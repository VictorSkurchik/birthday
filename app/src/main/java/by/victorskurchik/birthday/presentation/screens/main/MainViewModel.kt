package by.victorskurchik.birthday.presentation.screens.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import by.victorskurchik.birthday.domain.BirthdayRepository
import by.victorskurchik.birthday.domain.entities.Birthday
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val birthdayRepository: BirthdayRepository
) : ViewModel() {

    private val _birthdays = MutableStateFlow<List<Birthday>>(emptyList())
    val birthdays: StateFlow<List<Birthday>> = _birthdays

    init {
        viewModelScope.launch {
            birthdayRepository.fetchBirthdays().collect {
                _birthdays.value = it
            }
        }
    }
}