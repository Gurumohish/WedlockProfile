package com.appsmindstudio.wedlock_profile.utils

import com.appsmindstudio.wedlock_profile.R
import com.appsmindstudio.wedlock_profile.data.local.room.entity.DailyRecommendation
import com.appsmindstudio.wedlock_profile.data.local.room.entity.ProfileList
import com.appsmindstudio.wedlock_profile.data.model.MarryDetails
import com.appsmindstudio.wedlock_profile.data.model.ProfileDetails

object StaticDataList {

    val staticProfileList = listOf(
        ProfileList(
            marryDetails = MarryDetails(
                profile = R.drawable.athulya_ravi,
                name = "Athulya Ravi",
                age = "1996",
                height = "5 ft 5 in",
                language = "Tamil",
                caste = "Vanniyar",
                education = "BE",
                profession = "Actor",
                city = "Chennai",
                state = "Tamil Nadu",
                country = "India"
            )
        ),
        ProfileList(
            marryDetails = MarryDetails(
                profile = R.drawable.karthi,
                name = "Karthi",
                age = "1980",
                height = "6 ft 5 in",
                language = "Tamil",
                caste = "Cristian",
                education = "CA",
                profession = "Actor",
                city = "Chennai",
                state = "Tamil Nadu",
                country = "India"
            )
        ),
        ProfileList(
            marryDetails = MarryDetails(
                profile = R.drawable.siva_karthikeya,
                name = "Siva Karthikeya",
                age = "1992",
                height = "6 ft 2 in",
                language = "Tamil",
                caste = "Vanniyar",
                education = "MBBS",
                profession = "Actor",
                city = "Chennai",
                state = "Tamil Nadu",
                country = "India"
            )
        ),
        ProfileList(
            marryDetails = MarryDetails(
                profile = R.drawable.keerthi,
                name = "Keerthi Suresh",
                age = "1999",
                height = "5 ft 3 in",
                language = "Tamil",
                caste = "Poosam",
                education = "Bachelor's Degree",
                profession = "Actor",
                city = "Chennai",
                state = "Tamil Nadu",
                country = "India"
            )
        ),
        ProfileList(
            marryDetails = MarryDetails(
                profile = R.drawable.vijay,
                name = "Vijay",
                age = "1985",
                height = "6 ft 6 in",
                language = "Hindi",
                caste = "Maratti",
                education = "MBBS",
                profession = "Actor",
                city = "Delhi",
                state = "Delhi",
                country = "India"
            )
        ),
    )

    val staticDailyRecList = listOf(
        DailyRecommendation(
            marryDetails = MarryDetails(
                profile = R.drawable.priyanka,
                name = "Priyanka",
                age = "1996",
                height = "5 ft 5 in",
                language = "Tamil",
                caste = "Vanniyar",
                education = "MBBS",
                profession = "Actor",
                city = "Chennai",
                state = "Tamil Nadu",
                country = "India"
            )
        ),
        DailyRecommendation(
            marryDetails = MarryDetails(
                profile = R.drawable.anju_kurian,
                name = "Anju kurian",
                age = "1980",
                height = "6 ft 5 in",
                language = "Tamil",
                caste = "Cristian",
                education = "BE",
                profession = "Actor",
                city = "Chennai",
                state = "Tamil Nadu",
                country = "India"
            )
        ),
        DailyRecommendation(
            marryDetails = MarryDetails(
                profile = R.drawable.dulquer_salmaan,
                name = "Dulquer Salmaan",
                age = "1992",
                height = "6 ft 2 in",
                language = "Tamil",
                caste = "Vanniyar",
                education = "MBBS",
                profession = "Actor",
                city = "Chennai",
                state = "Tamil Nadu",
                country = "India"
            )
        ),
        DailyRecommendation(
            marryDetails = MarryDetails(
                profile = R.drawable.anjali,
                name = "Anjali",
                age = "1999",
                height = "5 ft 3 in",
                language = "Tamil",
                caste = "Poosam",
                education = "Bachelor's Degree",
                profession = "Actor",
                city = "Chennai",
                state = "Tamil Nadu",
                country = "India"
            )
        ),
        DailyRecommendation(
            marryDetails = MarryDetails(
                profile = R.drawable.sai_pallavi,
                name = "Sai Pallavi",
                age = "1985",
                height = "6 ft 6 in",
                language = "Hindi",
                caste = "Maratti",
                education = "MBBS",
                profession = "Actor",
                city = "Delhi",
                state = "Delhi",
                country = "India"
            )
        ),
    )

    val staticProfileDetailList = listOf(
        ProfileDetails(
            profile = R.drawable.karthi,
        ),
        ProfileDetails(
            profile = R.drawable.karthi1,
        ),
        ProfileDetails(
            profile = R.drawable.karthi2,
        ),
        ProfileDetails(
            profile = R.drawable.karthi3,
        ),
        ProfileDetails(
            profile = R.drawable.karthi4,
        ),
    )

}