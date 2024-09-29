package com.appsmindstudio.wedlock_profile.ui.screens.nav_screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.appsmindstudio.wedlock_profile.R
import com.appsmindstudio.wedlock_profile.ui.components.TextComponent
import com.appsmindstudio.wedlock_profile.viewmodel.ProfileDetailsScreenViewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ProfileDetailsScreen(
    name: String,
    description: String,
    onBackPressed: () -> Unit,
    viewModel: ProfileDetailsScreenViewModel = hiltViewModel()
) {

    val profileDetailLists by viewModel.profileDetailLists.observeAsState(emptyList())
    var position by remember { mutableIntStateOf(1) }
    val pagerState = rememberPagerState(pageCount = { profileDetailLists.size })

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {

        //It's storing for remember pager position
        LaunchedEffect(pagerState.currentPage) {
            position = pagerState.currentPage + 1
        }

        //It's scroll images in horizontally
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.fillMaxSize()
        ) { page ->
            ImageComponent(image = profileDetailLists[page].profile)
        }
        Box(
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(25.dp)
                .clickable { onBackPressed() } //navigate to GestureScreen when click this component
        ) {
            //This component for show profile's id
            Row {
                Icon(
                    painter = painterResource(id = R.drawable.arrow),
                    contentDescription = null,
                    modifier = Modifier
                        .size(20.dp),
                    tint = Color.White
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = "M9837832",
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }

        //This component for overlap above the uploaded images
        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
        ) {
            Column(
                horizontalAlignment = Alignment.End,
                modifier = Modifier.fillMaxWidth()
            ) {
                ImageCountComponent(
                    position,
                    profileDetailLists.size
                )
                Spacer(modifier = Modifier.height(30.dp))
                DetailsComponent(name, description)
            }
        }
    }
}

//This component for showing uploaded images
@Composable
fun ImageComponent(image: Int) {
    Image(
        modifier = Modifier
            .fillMaxSize(),
        painter = painterResource(id = image),
        contentDescription = null,
        contentScale = ContentScale.FillHeight
    )
}

//This component for Details of selected profile
@Composable
fun DetailsComponent(name: String, description: String) {
    Card(
        shape = RoundedCornerShape(
            topStart = 16.dp,
            topEnd = 16.dp,
            bottomStart = 0.dp,
            bottomEnd = 0.dp
        ),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(modifier = Modifier.padding(horizontal = 15.dp, vertical = 20.dp)) {
            TextComponent(
                text = name,
                color = Color.Black,
                size = 20.sp,
                weight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(5.dp))
            TextComponent(
                text = description,
                color = Color.Black,
                size = 14.sp,
                weight = FontWeight.Normal
            )
        }
    }
}

//This component for uploaded images count
@Composable
fun ImageCountComponent(position: Int, count: Int) {
    Column(modifier = Modifier.padding(end = 20.dp)) {
        Column(
            modifier = Modifier
                .background(Color.Black, shape = RoundedCornerShape(50.dp))
                .padding(horizontal = 12.dp)
        ) {
            Text(
                text = "${position}/$count",
                color = Color.White,
                fontSize = 12.sp,
                fontWeight = FontWeight.Light
            )
        }
    }
}