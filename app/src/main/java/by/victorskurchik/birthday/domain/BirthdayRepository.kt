package by.victorskurchik.birthday.domain

import by.victorskurchik.birthday.domain.entities.Birthday
import kotlinx.coroutines.flow.Flow

interface BirthdayRepository {

    suspend fun fetchBirthdays(): Flow<List<Birthday>>

    suspend fun addOrUpdateBirthday(birthday: Birthday)

    suspend fun deleteBirthday(birthday: Birthday)
}