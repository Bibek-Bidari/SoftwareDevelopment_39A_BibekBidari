
package com.example.c39a

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class CardActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            CardApp()
        }
    }
}

fun getScreenBackgroundColor(): Color = Color(0xFF03A9F4)
fun getButtonContainerColor(): Color = Color(0xFF2640D2)

@Composable
fun CardApp() {
    var selectedScreen by remember { mutableStateOf("Home") }
    var selectedCategory by remember { mutableStateOf("Card") }

    if (selectedScreen == "Home") {
        HomeScreen(
            onCategoryClick = {
                selectedCategory = it
                selectedScreen = "Cards"
            }
        )
    } else {
        CardsScreen(
            title = selectedCategory,
            onBack = {
                selectedScreen = "Home"
            }
        )
    }
}

@Composable
fun HomeScreen(onCategoryClick: (String) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(getScreenBackgroundColor())
            .verticalScroll(rememberScrollState())
            .padding(12.dp)
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = "Card",
                    fontSize = 25.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "Simple and easy to use app",
                    fontSize = 13.sp,
                    color = Color.White
                )
            }

            Text(
                text = "👤",
                modifier = Modifier
                    .clip(CircleShape)
                    .background(Color.White)
                    .padding(8.dp),
                fontSize = 20.sp
            )
        }

        Spacer(modifier = Modifier.height(35.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Column(modifier = Modifier.weight(1f)) {
                CategoryItem("📕", "Text") {
                    onCategoryClick("Text")
                }

                CategoryItem("👨‍🦱", "Character") {
                    onCategoryClick("Character")
                }

                CategoryItem("🔑", "Password") {
                    onCategoryClick("Password")
                }
            }

            Column(modifier = Modifier.weight(1f)) {
                CategoryItem("🏠", "Address") {
                    onCategoryClick("Address")
                }

                CategoryItem("💳", "Bank card") {
                    onCategoryClick("Bank card")
                }

                CategoryItem("📦", "Logistics") {
                    onCategoryClick("Logistics")
                }
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 6.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(Color.White)
                .clickable { onCategoryClick("Settings") }
                .padding(14.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("⚙️", fontSize = 25.sp)

            Spacer(modifier = Modifier.width(12.dp))

            Text(
                text = "Settings",
                color = Color.DarkGray,
                fontSize = 16.sp
            )
        }
    }
}

@Composable
fun CategoryItem(
    emoji: String,
    title: String,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(Color.White)
            .clickable { onClick() }
            .padding(vertical = 18.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = emoji,
            fontSize = 32.sp
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = title,
            fontSize = 14.sp,
            color = Color.DarkGray
        )

        Text(
            text = "Tap to view",
            fontSize = 10.sp,
            color = Color.LightGray
        )
    }
}

fun getCardColor(title: String): Color {
    return when {
        title.contains("Dribbble", ignoreCase = true) -> Color(0xFFFFB52E)
        title.contains("HJM", ignoreCase = true) -> Color(0xFF3999F5)
        title.contains("Tom", ignoreCase = true) -> Color(0xFF54C5A5)
        title.contains("ICBC", ignoreCase = true) || title.contains("Debit", ignoreCase = true) -> Color(0xFF6555EE)
        title.contains("Young", ignoreCase = true) -> Color(0xFFB77D70)
        title.contains("Address", ignoreCase = true) -> Color(0xFF528BEF)
        else -> Color(0xFF3999F5)
    }
}

@Composable
fun CardsScreen(
    title: String,
    onBack: () -> Unit
) {
    var showNewCard by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(getScreenBackgroundColor())
            .padding(12.dp)
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "‹  $title",
                color = Color.White,
                fontSize = 23.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.clickable { onBack() }
            )

            Text("👤", fontSize = 23.sp)
        }

        Spacer(modifier = Modifier.height(18.dp))

        Column(
            modifier = Modifier
                .weight(1f)
                .verticalScroll(rememberScrollState())
        ) {
            if (title == "Card" || title == "Bank card") {
                InfoCard(
                    "Dribbble",
                    "Paid card",
                    "••••••••••••",
                    getCardColor("Dribbble")
                )

                InfoCard(
                    "HJM",
                    "173*****8838",
                    "",
                    getCardColor("HJM")
                )

                InfoCard(
                    "Tom",
                    "Room 601, Building 8, Zhongnan Century City",
                    "130*****9920",
                    getCardColor("Tom")
                )

                InfoCard(
                    "1882 **** **** 8695",
                    "ICBC",
                    "Debit Card                         12/19",
                    getCardColor("ICBC")
                )
            } else {
                InfoCard(
                    title,
                    "My saved $title",
                    "Tap + to add a new item",
                    getCardColor(title)
                )
            }

            InfoCard(
                "Young",
                "This is the story of me and them",
                "",
                getCardColor("Young")
            )

            InfoCard(
                "Address",
                "Jinjin street, golden chrysanthemum Road",
                "",
                getCardColor("Address")
            )
        }

        if (showNewCard) {
            Text(
                text = "New $title selected",
                color = Color.White,
                modifier = Modifier.padding(8.dp)
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            Button(
                onClick = { showNewCard = !showNewCard },
                shape = CircleShape,
                colors = ButtonDefaults.buttonColors(
                    containerColor = getButtonContainerColor()
                ),
                contentPadding = PaddingValues(0.dp),
                modifier = Modifier.size(52.dp)
            ) {
                Text(
                    text = "+",
                    fontSize = 30.sp,
                    color = Color.White
                )
            }
        }
    }
}

@Composable
fun InfoCard(
    title: String,
    description: String,
    detail: String,
    color: Color
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 10.dp)
            .clip(RoundedCornerShape(9.dp))
            .background(color)
            .heightIn(min = 82.dp)
            .padding(14.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = title,
            color = Color.White,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = description,
            color = Color.White,
            fontSize = 12.sp
        )

        if (detail.isNotEmpty()) {
            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = detail,
                color = Color.White,
                fontSize = 10.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(onCategoryClick = {})
}

@Preview(showBackground = true)
@Composable
fun CardsScreenPreview() {
    CardsScreen(title = "Bank card", onBack = {})
}
