package by.victorskurchik.birthday.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import by.victorskurchik.birthday.data.db.entities.BirthdayEntity

@Database(entities = [BirthdayEntity::class], version = 1)
abstract class BirthdayDatabase : RoomDatabase() {
    abstract fun birthdayDao(): BirthdayDao
}

internal const val DATABASE_NAME = "birthday_database"