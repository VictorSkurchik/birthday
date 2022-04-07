package by.victorskurchik.birthday.data.db

import androidx.room.*
import by.victorskurchik.birthday.data.db.entities.BirthdayEntity

@Dao
interface BirthdayDao {

    @Insert
    suspend fun insert(entity: BirthdayEntity)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(entity: BirthdayEntity)

    @Delete
    suspend fun delete(entity: BirthdayEntity)

    @Query("SELECT * from ${BirthdayEntity.TABLE_NAME}")
    suspend fun getAll(): List<BirthdayEntity>
}