package com.appsmindstudio.wedlock_profile.data.local.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.appsmindstudio.wedlock_profile.data.local.room.entity.DailyRecommendation

@Dao
interface DailyRecommendationsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDailyRecommendations(gesture: List<DailyRecommendation>)

    @Query("SELECT * FROM DailyRecommendations_Table")
    fun getAllDailyRecommendations(): List<DailyRecommendation>

    @Delete
    suspend fun deleteDailyRecommendationsDao(dailyRecommendation: DailyRecommendation)

}