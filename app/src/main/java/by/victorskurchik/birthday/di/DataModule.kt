package by.victorskurchik.birthday.di

import android.content.Context
import androidx.room.Room
import by.victorskurchik.birthday.data.BirthdayRepositoryImpl
import by.victorskurchik.birthday.data.db.BirthdayDao
import by.victorskurchik.birthday.data.db.BirthdayDatabase
import by.victorskurchik.birthday.data.db.DATABASE_NAME
import by.victorskurchik.birthday.domain.BirthdayRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    @Singleton
    fun provideRoomDatabase(@ApplicationContext context: Context): BirthdayDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            BirthdayDatabase::class.java,
            DATABASE_NAME
        ).fallbackToDestructiveMigration().build()
    }

    @Provides
    @Singleton
    fun provideBirthdayDao(birthdayDatabase: BirthdayDatabase): BirthdayDao {
        return birthdayDatabase.birthdayDao()
    }

    @Provides
    @Singleton
    fun provideBirthdayRepository(birthdayDao: BirthdayDao): BirthdayRepository {
        return BirthdayRepositoryImpl(birthdayDao)
    }
}