package com.appsmindstudio.wedlock_profile.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.appsmindstudio.wedlock_profile.data.model.ProfileDetails
import com.appsmindstudio.wedlock_profile.utils.StaticDataList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileDetailsScreenViewModel @Inject constructor() :
    ViewModel() {

    private val _profileDetailLists = MutableLiveData<List<ProfileDetails>>()
    val profileDetailLists: LiveData<List<ProfileDetails>> get() = _profileDetailLists

    init {
        viewModelScope.launch {
            _profileDetailLists.value = StaticDataList.staticProfileDetailList
        }
    }

}