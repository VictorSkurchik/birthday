package by.victorskurchik.birthday.domain

import by.victorskurchik.birthday.domain.entities.Birthday

interface BirthdayRepository {

    suspend fun fetchBirthdays(): List<Birthday>

    suspend fun addOrUpdateBirthday(birthday: Birthday)

    suspend fun deleteBirthday(birthday: Birthday)
}