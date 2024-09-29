package com.appsmindstudio.wedlock_profile.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.appsmindstudio.wedlock_profile.data.local.room.entity.ProfileList
import com.appsmindstudio.wedlock_profile.data.local.room.repository.ProfileRepository
import com.appsmindstudio.wedlock_profile.utils.StaticDataList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(private val profileRepository: ProfileRepository) :
    ViewModel() {

    private val _profileListLists = MutableLiveData<List<ProfileList>>()
    val profileListLists: LiveData<List<ProfileList>> get() = _profileListLists

    init {
        viewModelScope.launch {
            if (profileRepository.getAllProfile().isEmpty())
                profileRepository.insertProfile(StaticDataList.staticProfileList)
            _profileListLists.value = profileRepository.getAllProfile()
        }
    }

    fun removeGesture(profileList: ProfileList) {
        viewModelScope.launch {
            profileRepository.deleteProfile(profileList)
            _profileListLists.value = _profileListLists.value?.filter { it != profileList }
        }
    }
}