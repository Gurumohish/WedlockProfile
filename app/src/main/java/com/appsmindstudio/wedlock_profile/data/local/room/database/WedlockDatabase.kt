package com.appsmindstudio.wedlock_profile.data.local.room.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.appsmindstudio.wedlock_profile.data.local.room.dao.DailyRecommendationsDao
import com.appsmindstudio.wedlock_profile.data.local.room.dao.ProfileListDao
import com.appsmindstudio.wedlock_profile.data.local.room.entity.DailyRecommendation
import com.appsmindstudio.wedlock_profile.data.local.room.entity.ProfileList

@Database(entities = [ProfileList::class, DailyRecommendation::class], version = 1)
abstract class WedlockDatabase : RoomDatabase() {
    abstract fun profileListDao(): ProfileListDao
    abstract fun dailyRecommendationsDao(): DailyRecommendationsDao

    companion object {
        const val DATABASE_NAME = "WedlockProfile"
    }
}