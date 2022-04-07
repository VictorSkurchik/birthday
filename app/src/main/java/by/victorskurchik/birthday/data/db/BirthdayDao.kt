package by.victorskurchik.birthday.data.db

import androidx.room.*
import by.victorskurchik.birthday.data.db.entities.BirthdayEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface BirthdayDao {

    @Insert
    suspend fun insert(entity: BirthdayEntity)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(entity: BirthdayEntity)

    @Delete
    suspend fun delete(entity: BirthdayEntity)

    @Query("SELECT * from ${BirthdayEntity.TABLE_NAME}")
    fun getAllBirthdaysFlow(): Flow<List<BirthdayEntity>>
}