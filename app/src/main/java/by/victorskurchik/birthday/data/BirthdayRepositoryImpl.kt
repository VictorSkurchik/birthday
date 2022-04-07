package by.victorskurchik.birthday.data

import by.victorskurchik.birthday.data.db.BirthdayDao
import by.victorskurchik.birthday.domain.BirthdayRepository
import by.victorskurchik.birthday.domain.entities.Birthday
import javax.inject.Inject

class BirthdayRepositoryImpl @Inject constructor(
    private val birthdayDao: BirthdayDao
) : BirthdayRepository {

    override suspend fun fetchBirthdays(): List<Birthday> {
        return birthdayDao.getAll().map { it.toBirthday() }
    }

    override suspend fun addOrUpdateBirthday(birthday: Birthday) {
        val records = fetchBirthdays()
        val recordForDate = records.firstOrNull { it.fullName == birthday.fullName }

        if (recordForDate == null) {
            birthdayDao.insert(birthday.toBirthdayEntity())
        } else {
            birthdayDao.update(birthday.toBirthdayEntity())
        }
    }

    override suspend fun deleteBirthday(birthday: Birthday) {
        birthdayDao.delete(birthday.toBirthdayEntity())
    }
}