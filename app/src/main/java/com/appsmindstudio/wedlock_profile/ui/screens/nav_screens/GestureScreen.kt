package com.appsmindstudio.wedlock_profile.ui.screens.nav_screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.appsmindstudio.wedlock_profile.R
import com.appsmindstudio.wedlock_profile.ui.components.GestureCardComponent
import com.appsmindstudio.wedlock_profile.viewmodel.GestureScreenViewModel

@Composable
fun GestureScreen(
    onBackPressed: () -> Unit,
    navigateToProfileDetailsScreen: (String, String) -> Unit,
    viewModel: GestureScreenViewModel = hiltViewModel()
) {
    OverlappingBoxesPreview(viewModel, navigateToProfileDetailsScreen, onBackPressed)
}

@Composable
fun OverlappingBoxesPreview(
    viewModel: GestureScreenViewModel,
    navigateToProfileDetailsScreen: (String, String) -> Unit,
    onBackPressed: () -> Unit
) {
    val dailyRecommendationList by viewModel.dailyRecommendationList.observeAsState(null)
    val context = LocalContext.current
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    listOf(Color(0xFFF3C63D), Color(0xFFF8EFD5))
                )
            )

    ) {
        Row(
            modifier = Modifier
                .padding(top = 30.dp, start = 25.dp)
                .clickable { onBackPressed() }) {
            Icon(
                painter = painterResource(id = R.drawable.arrow),
                contentDescription = null,
                modifier = Modifier
                    .size(20.dp),
                tint = Color.White
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = stringResource(id = R.string.recommendation_header),
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Box(modifier = Modifier.padding(top = 100.dp, start = 25.dp, end = 25.dp)) {

            dailyRecommendationList?.let { dailyRecommendationList ->

                ConditionalVisibility(visible = dailyRecommendationList.isNotEmpty() && dailyRecommendationList.size > 1)

                if (dailyRecommendationList.isNotEmpty()) {

                    dailyRecommendationList[0].marryDetails.apply {

                        GestureCardComponent(
                            image = profile,
                            title = name,
                            description = "${age}, ${height}, ${language}, ${caste}, ${education}, ${profession}, ${city}, ${state}, $country",
                            {
                                navigateToProfileDetailsScreen(
                                    name,
                                    "${age}, ${height}, ${language}, ${caste}, ${education}, ${profession}, ${city}, ${state}, $country"
                                )
                            },
                            context,
                            onDelete = { viewModel.removeDailyRecommendation(dailyRecommendationList[0]) }
                        )
                    }
                } else Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text =  stringResource(R.string.no_profile),
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}

@Composable
fun ConditionalVisibility(
    visible: Boolean
) {
    if (visible) {
        Box {
            Card(
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .width(280.dp)
                    .height(100.dp),
                shape = RoundedCornerShape(13.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0x75FFFFFF)),

                ) {}
            Card(
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .width(350.dp)
                    .height(100.dp)
                    .padding(11.dp), shape = RoundedCornerShape(13.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0x80FFFFFF))
            ) {}
        }
    }
}