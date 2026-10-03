package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.NotificationsNone
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class Spotify : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            SpotifyHome()
        }
    }
}

@Composable
fun SpotifyHome() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF121212))
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Recently played",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )

            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Icon(
                    Icons.Default.NotificationsNone,
                    contentDescription = "Notifications",
                    tint = Color.White
                )

                Icon(
                    Icons.Default.History,
                    contentDescription = "History",
                    tint = Color.White
                )

                Icon(
                    Icons.Default.Settings,
                    contentDescription = "Settings",
                    tint = Color.White
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            RecentItem(R.drawable.images, "Lana Del Rey")
            RecentItem(R.drawable.images, "Marvin Gaye")
        }

        Spacer(modifier = Modifier.height(28.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(R.drawable.images),
                contentDescription = "2021 Review",
                modifier = Modifier.size(68.dp),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.width(12.dp))

            Column {
                Text(
                    text = "#SPOTIFYWRAPPED",
                    color = Color.Gray,
                    fontSize = 11.sp
                )

                Text(
                    text = "Your 2021 in review",
                    color = Color.White,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            ReviewCard(
                R.drawable.images,
                "Your Top Songs 2021",
                Color(0xFFD8F779),
                Modifier.weight(1f)
            )

            ReviewCard(
                R.drawable.images,
                "Your Artists Revealed",
                Color(0xFFC6B5D8),
                Modifier.weight(1f)
            )
        }

        Spacer(modifier = Modifier.height(26.dp))

        Text(
            text = "Editor's picks",
            color = Color.White,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(12.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            EditorCard(
                R.drawable.images,
                "Ed Sheeran, Big Sean,\nJuice WRLD, Post Malone",
                Modifier.weight(1f)
            )

            EditorCard(
                R.drawable.images,
                "Mitski, Tame Impala,\nGlass Animals, Charli XCX",
                Modifier.weight(1f)
            )
        }
    }
}

@Composable
fun RecentItem(image: Int, name: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(image),
            contentDescription = name,
            modifier = Modifier
                .size(110.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = name,
            color = Color.White,
            fontSize = 14.sp
        )
    }
}

@Composable
fun ReviewCard(
    image: Int,
    title: String,
    color: Color,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Image(
            painter = painterResource(image),
            contentDescription = title,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f)
                .background(color),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = title,
            color = Color.White,
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium
        )
    }
}

@Composable
fun EditorCard(
    image: Int,
    title: String,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Image(
            painter = painterResource(image),
            contentDescription = title,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = title,
            color = Color.LightGray,
            fontSize = 13.sp,
            lineHeight = 19.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SpotifyPreview() {
    SpotifyHome()
}
