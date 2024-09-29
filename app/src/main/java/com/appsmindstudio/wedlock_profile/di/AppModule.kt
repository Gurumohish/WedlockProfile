package com.appsmindstudio.wedlock_profile.di

import android.app.Application
import androidx.room.Room
import com.appsmindstudio.wedlock_profile.data.local.room.database.WedlockDatabase
import com.appsmindstudio.wedlock_profile.data.local.room.repository.DailyRecommendationRepository
import com.appsmindstudio.wedlock_profile.data.local.room.repository.ProfileRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun providesDatabase(app: Application): WedlockDatabase =
        Room.databaseBuilder(app, WedlockDatabase::class.java, WedlockDatabase.DATABASE_NAME)
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    @Singleton
    fun provideProfileRepository(database: WedlockDatabase): ProfileRepository {
        return ProfileRepository(database.profileListDao())
    }

    @Provides
    @Singleton
    fun provideDailyRecommendationRepository(database: WedlockDatabase): DailyRecommendationRepository {
        return DailyRecommendationRepository(database.dailyRecommendationsDao())
    }
}