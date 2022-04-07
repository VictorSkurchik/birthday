package by.victorskurchik.birthday.data

import by.victorskurchik.birthday.data.db.BirthdayDao
import by.victorskurchik.birthday.domain.BirthdayRepository
import by.victorskurchik.birthday.domain.entities.Birthday
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class BirthdayRepositoryImpl @Inject constructor(
    private val birthdayDao: BirthdayDao
) : BirthdayRepository {

    override suspend fun fetchBirthdays(): Flow<List<Birthday>> {
        return birthdayDao.getAllBirthdaysFlow().map { list -> list.map { it.toBirthday() } }
    }

    override suspend fun addOrUpdateBirthday(birthday: Birthday) {
        val recordsFlow = fetchBirthdays()
        val prevPersonRecord = recordsFlow.first().firstOrNull {
            it.fullName == birthday.fullName
        }

        if (prevPersonRecord == null) {
            birthdayDao.insert(birthday.toBirthdayEntity())
        } else {
            birthdayDao.update(birthday.toBirthdayEntity())
        }
    }

    override suspend fun deleteBirthday(birthday: Birthday) {
        birthdayDao.delete(birthday.toBirthdayEntity())
    }
}