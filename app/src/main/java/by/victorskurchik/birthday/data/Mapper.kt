package by.victorskurchik.birthday.data

import by.victorskurchik.birthday.data.db.entities.BirthdayEntity
import by.victorskurchik.birthday.domain.entities.Birthday

fun Birthday.toBirthdayEntity(): BirthdayEntity {
    return BirthdayEntity(this.fullName, this.date)
}

fun BirthdayEntity.toBirthday(): Birthday {
    return Birthday(this.fullName, this.date)
}