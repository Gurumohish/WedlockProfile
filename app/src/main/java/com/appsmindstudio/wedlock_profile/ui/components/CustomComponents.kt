package com.appsmindstudio.wedlock_profile.ui.components

import android.content.Context
import android.widget.Toast
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.appsmindstudio.wedlock_profile.R

@Composable
fun ProfileCardComponent(
    @DrawableRes image: Int,
    title: String,
    description: String,
    navigateToProfileDetailsScreen: () -> Unit,
    context: Context,
    onDelete: () -> Unit
) {
    Card(
        modifier = Modifier
            .height(360.dp)
            .width(215.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.7f)
                    .clickable { navigateToProfileDetailsScreen() },
                painter = painterResource(id = image),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )

            // This is for vertical alignment of your view
            Column(
                modifier = Modifier
                    .weight(0.4f)
                    .padding(top = 10.dp, start = 10.dp, end = 10.dp)
                    .clickable { navigateToProfileDetailsScreen() }) {
                TextComponent(
                    text = title,
                    color = Color.Black,
                    size = 16.sp,
                    weight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(3.dp))
                TextComponent(text = description, color = Color.Black, 13.sp, FontWeight.Normal)
            }

            // This is for horizontal alignment of your view
            Row(
                modifier = Modifier
                    .weight(0.2f)
                    .padding(start = 10.dp, end = 10.dp, bottom = 6.dp)
            ) {
                Button(
                    modifier = Modifier
                        .size(60.dp, 35.dp)
                        .height(IntrinsicSize.Min),  // Center the content vertically
                    contentPadding = PaddingValues(0.dp),
                    onClick = {
                        onDelete()
                        Toast.makeText(
                            context,
                            "$title profile removed from the stack",
                            Toast.LENGTH_SHORT
                        ).show()
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFD09B04),
                        contentColor = Color.White
                    )
                ) {
                    Text(text = "Yes")
                }
                Spacer(modifier = Modifier.width(10.dp))
                OutlinedButton(
                    modifier = Modifier
                        .size(60.dp, 35.dp)
                        .height(IntrinsicSize.Min),  // Center the content vertically
                    contentPadding = PaddingValues(0.dp),
                    onClick = {
                        onDelete()
                        Toast.makeText(
                            context,
                            "$title profile removed from the stack",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                ) {
                    Text(text = "No", color = Color.Black)
                }
            }
        }
    }
}

@Composable
fun GestureCardComponent(
    @DrawableRes image: Int,
    title: String,
    description: String,
    navigateToProfileDetailsScreen: () -> Unit,
    context: Context,
    onDelete: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(550.dp)
            .padding(top = 22.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {

        // This is for vertical alignment of your view
        Column {
            Image(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(0.7f)
                    .clickable { navigateToProfileDetailsScreen() },
                painter = painterResource(id = image),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(15.dp))
            Column(
                modifier = Modifier
                    .weight(0.2f)
                    .padding(start = 15.dp, end = 15.dp)
                    .clickable { navigateToProfileDetailsScreen() }) {
                TextComponent(
                    text = title,
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
                HorizontalDivider(
                    color = Color(0X10000000),
                    modifier = Modifier.padding(
                        top = 10.dp
                    )
                )
            }
            ButtonComponent(
                onDelete, context, title, modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.1f)
                    .padding(end = 15.dp, bottom = 15.dp)
            )
        }
    }
}

// This is for button component
@Composable
fun ButtonComponent(onDelete: () -> Unit, context: Context, title: String, modifier: Modifier) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.End
    ) {
        Text(
            text = "Like her?",
            color = Color.Black,
            textAlign = TextAlign.Center,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.width(5.dp))
        OutlinedButton(
            onClick = {
                onDelete()
                Toast.makeText(
                    context,
                    "$title profile removed from the stack",
                    Toast.LENGTH_SHORT
                ).show()
            }, modifier = Modifier
                .size(48.dp, 35.dp)
                .height(IntrinsicSize.Min),
            contentPadding = PaddingValues(0.dp)

        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_close),
                contentDescription = null, tint = Color.Gray
            )
        }
        Spacer(modifier = Modifier.width(10.dp))
        Button(
            onClick = {
                onDelete()
                Toast.makeText(
                    context,
                    "$title profile removed from the stack",
                    Toast.LENGTH_SHORT
                ).show()
            }, modifier = Modifier
                .size(68.dp, 35.dp)
                .height(IntrinsicSize.Min), // Center the content vertically
            contentPadding = PaddingValues(0.dp), // Remove default padding
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFD09B04),
                contentColor = Color.White,
            )
        ) {
            Icon(
                painter = painterResource(id = R.drawable.tick),
                contentDescription = null,
                modifier = Modifier.size(18.dp),
                tint = Color.White
            )
        }
    }
}

@Composable
fun TextComponent(text: String, color: Color, size: TextUnit, weight: FontWeight) {
    Text(text = text, color = color, fontSize = size, fontWeight = weight)
}