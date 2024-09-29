package com.appsmindstudio.wedlock_profile.data.local.room.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.appsmindstudio.wedlock_profile.data.model.MarryDetails

@Entity("DailyRecommendations_Table")
data class DailyRecommendation(
    @PrimaryKey(autoGenerate = true)
    val recommendId: Long = 0L,
    @Embedded
    val marryDetails: MarryDetails
)