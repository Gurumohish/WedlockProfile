package com.appsmindstudio.wedlock_profile.ui.screens.nav_screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
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
import com.appsmindstudio.wedlock_profile.ui.components.ProfileCardComponent
import com.appsmindstudio.wedlock_profile.utils.OnBackPressedCall
import com.appsmindstudio.wedlock_profile.viewmodel.HomeScreenViewModel

@Composable
fun HomeScreen(
    navigateToGestureScreen: () -> Unit,
    navigateToProfileDetailsScreen: (String, String) -> Unit,
    viewModel: HomeScreenViewModel = hiltViewModel()
) {

    OnBackPressedCall()

    val gestureLists by viewModel.profileListLists.observeAsState(null)
    val context = LocalContext.current

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    listOf(Color(0xFFF3C63D), Color(0xFFF7D87C))
                )
            )
    ) {
        Column {

            MyMatchesComponent(navigateToGestureScreen)

            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                gestureLists?.let { gestureLists ->

                    if (gestureLists.isNotEmpty()) {

                        PendingComponent(gestureLists.size)

                        LazyRow(
                            modifier = Modifier.fillMaxSize(),
                            horizontalArrangement = Arrangement.spacedBy(20.dp)
                        ) {
                            item {// This is for setting the spacing between each item.
                                Spacer(modifier = Modifier.width(5.dp))
                            }
                            items(gestureLists) { gesture ->
                                gesture.wedlockDetails.apply {
                                    // This is for the cards view component
                                    ProfileCardComponent(
                                        image = profile,
                                        title = name,
                                        description = "${age}, ${height}, ${language}, ${caste}, ${education}, ${profession}, ${city}, ${state}, $country",
                                        {
                                            navigateToProfileDetailsScreen(
                                                name,
                                                "${age}, ${height}, ${language}, ${caste}, ${education}, ${profession}, ${city}, ${state}, $country"
                                            )
                                        },
                                        context, onDelete = { viewModel.removeGesture(gesture) }
                                    )
                                }
                            }
                            item {
                                Spacer(modifier = Modifier.width(5.dp))
                            }
                        }
                    } else Text(
                        text = stringResource(R.string.no_profile),
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

// This is for my matches header text
@Composable
fun MyMatchesComponent(navigateToGestureScreen: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(25.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(R.string.my_matches_header),
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp
        )
        Spacer(modifier = Modifier.weight(1f))
        Icon(
            painter = painterResource(id = R.drawable.more),
            contentDescription = null,
            modifier = Modifier
                .size(20.dp)
                .clickable { navigateToGestureScreen() },
            tint = Color.White
        )
    }
}

// This component handles pending profiles text.
@Composable
fun PendingComponent(newCount: Int) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 25.dp, end = 25.dp, top = 10.dp, bottom = 25.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = "8 Profile pending with me",
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        )
        Spacer(modifier = Modifier.weight(1f))
        OutlinedButton(
            onClick = { },
            border = BorderStroke(1.dp, Color.White),
            modifier = Modifier
                .size(60.dp, 25.dp)
                .height(IntrinsicSize.Min), // Center the content vertically
            contentPadding = PaddingValues(0.dp) // Remove default padding
        ) {
            Text(
                text = "$newCount NEW",
                color = Color.White,
                textAlign = TextAlign.Center,
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}