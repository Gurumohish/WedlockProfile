package com.appsmindstudio.wedlock_profile.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.appsmindstudio.wedlock_profile.data.local.room.entity.DailyRecommendation
import com.appsmindstudio.wedlock_profile.data.local.room.repository.DailyRecommendationRepository
import com.appsmindstudio.wedlock_profile.utils.StaticDataList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GestureScreenViewModel @Inject constructor(private val dailyRecommendationRepository: DailyRecommendationRepository) :
    ViewModel() {

    private val _dailyRecommendationList = MutableLiveData<List<DailyRecommendation>>()
    val dailyRecommendationList: LiveData<List<DailyRecommendation>> get() = _dailyRecommendationList

    init {
        viewModelScope.launch {
            if (dailyRecommendationRepository.getAllDailyRecommendation().isEmpty())
                dailyRecommendationRepository.insertDailyRecommendation(StaticDataList.staticDailyRecList)
            _dailyRecommendationList.value = dailyRecommendationRepository.getAllDailyRecommendation()
        }
    }

    fun removeDailyRecommendation(dailyRecommendation: DailyRecommendation) {
        viewModelScope.launch {
            dailyRecommendationRepository.deleteDailyRecommendation(dailyRecommendation)
            _dailyRecommendationList.value = _dailyRecommendationList.value?.filter { it != dailyRecommendation }
        }
    }
}