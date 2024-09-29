package com.appsmindstudio.wedlock_profile.data.local.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.appsmindstudio.wedlock_profile.data.local.room.entity.ProfileList

@Dao
interface ProfileListDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProfile(profileList: List<ProfileList>)

    @Query("SELECT * FROM Profile_Table")
    fun getAllProfile(): List<ProfileList>

    @Delete
    suspend fun deleteProfile(profileList: ProfileList)


}