package by.victorskurchik.birthday.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import by.victorskurchik.birthday.data.db.entities.BirthdayEntity.Companion.TABLE_NAME

@Entity(tableName = TABLE_NAME)
data class BirthdayEntity(

    @PrimaryKey
    @ColumnInfo(name = COLUMN_FULL_NAME)
    val fullName: String,

    @ColumnInfo(name = COLUMN_DATE)
    val date: String
) {

    companion object {
        internal const val TABLE_NAME = "birthday"
        internal const val COLUMN_FULL_NAME = "fullName"
        internal const val COLUMN_DATE = "date"
    }
}

