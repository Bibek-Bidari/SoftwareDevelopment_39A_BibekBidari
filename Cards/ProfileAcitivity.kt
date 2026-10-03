
package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreHoriz
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class ProfileActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            ProfileBody()
        }
    }
}

@Composable
fun ProfileBody() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(12.dp),
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = "Back"
            )

            Text(
                text = "Bibek Bidari",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )

            Icon(
                imageVector = Icons.Default.MoreHoriz,
                contentDescription = "More"
            )
        }

        Spacer(modifier = Modifier.height(25.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Image(
                painter = painterResource(R.drawable.images),
                contentDescription = "Profile Picture",
                modifier = Modifier
                    .size(90.dp)
                    .clip(CircleShape)
                    .background(Color.LightGray),
                contentScale = ContentScale.Crop
            )

            ProfileStat("10k", "Posts")
            ProfileStat("1M", "Followers")
            ProfileStat("90k", "Following")
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Bibek Bidari",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = buildAnnotatedString {
                append("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ")
                withStyle(style = SpanStyle(color = Color.Blue)) {
                    append("#hashtag")
                }
            },
            fontSize = 15.sp
        )

        Text(
            text = "Link goes here",
            color = Color.Blue,
            fontSize = 15.sp

        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = buildAnnotatedString {
                append("Followed by ")
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append("username")
                }
                append(" and ")
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append("username")
                }
            },
            fontSize = 14.sp
        )

        Spacer(modifier = Modifier.height(15.dp))

        OutlinedButton(
            onClick = {},
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(6.dp),
            border = BorderStroke(1.dp, Color.LightGray)
        ) {
            Text(
                text = "Button",
                color = Color.Black,
                fontWeight = FontWeight.Bold
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(6.dp)
        ) {

            Button(
                onClick = {},
                modifier = Modifier.weight(1f),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Blue
                ),
                contentPadding = PaddingValues(horizontal = 4.dp),
                shape = RoundedCornerShape(6.dp)
            ) {
                Text("Follow", color = Color.White, maxLines = 1, fontSize = 14.sp)
            }

            OutlinedButton(
                onClick = {},
                modifier = Modifier.weight(1f),
                contentPadding = PaddingValues(horizontal = 4.dp),
                shape = RoundedCornerShape(6.dp)
            ) {
                Text("Message", color = Color.Black, maxLines = 1, fontSize = 14.sp)
            }

            OutlinedButton(
                onClick = {},
                modifier = Modifier.weight(1f),
                contentPadding = PaddingValues(horizontal = 4.dp),
                shape = RoundedCornerShape(6.dp)
            ) {
                Text("Email", color = Color.Black, maxLines = 1, fontSize = 14.sp)
            }

            OutlinedButton(
                onClick = {},
                modifier = Modifier.width(45.dp),
                contentPadding = PaddingValues(0.dp),
                shape = RoundedCornerShape(6.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowDown,
                    contentDescription = "More options",
                    tint = Color.Black
                )
            }
        }

        Spacer(modifier = Modifier.height(18.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            StoryItem(R.drawable.images, "Story 1")
            StoryItem(R.drawable.images, "Story 2")
            StoryItem(R.drawable.images, "Story 3")
            StoryItem(R.drawable.images, "Story 4")
            StoryItem(R.drawable.images, "Story 5")
        }
    }
}

@Composable
fun ProfileStat(number: String, label: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = number,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = label,
            fontSize = 12.sp,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun StoryItem(image: Int, title: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(image),
            contentDescription = title,
            modifier = Modifier
                .size(55.dp)
                .clip(CircleShape)
                .background(Color.LightGray),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = title,
            fontSize = 11.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ProfilePreview() {
    ProfileBody()
}
