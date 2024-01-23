package com.llsdc.whatsappui.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.llsdc.whatsappui.R
import com.llsdc.whatsappui.ui.screens.CallsContentTab
import com.llsdc.whatsappui.ui.screens.ChatsContentTab
import com.llsdc.whatsappui.ui.screens.StatusContentTab

@Composable
fun TabBarComponent() {
    var selectedTab by remember { mutableStateOf("chats") }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .background(MaterialTheme.colorScheme.primary)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconComponent(R.drawable.ic_groups)
        Spacer(modifier = Modifier.size(30.dp))
        TabItem("Chats", selectedTab == "chats") {
            selectedTab = "chats"
        }
        Spacer(modifier = Modifier.weight(1f))
        TabItem("Calls", selectedTab == "calls") {
            selectedTab = "calls"
        }
        Spacer(modifier = Modifier.weight(1f))
        TabItem("Status", selectedTab == "status") {
            selectedTab = "status"
        }
    }
    when (selectedTab) {
        "chats" -> ChatsContentTab()
        "calls" -> CallsContentTab()
        "status" -> StatusContentTab()
    }
}

@Composable
fun TabItem(text: String, isSelected: Boolean, onClick: () -> Unit) {
    Column(
        modifier = Modifier
            .clickable { onClick() }
    ) {
        Text(
            text = text,
            style = TextStyle(
                fontSize = 16.sp,
                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                color = MaterialTheme.colorScheme.tertiary
            ),
        )
    }
}

//@Composable
//fun TabItem(text: String, isSelected: Boolean, onClick: () -> Unit) {
//    Text(
//        text = text,
//        style = TextStyle(
//            fontSize = 16.sp,
//            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
//            color = MaterialTheme.colorScheme.tertiary
//        ),
//        modifier = Modifier.clickable { onClick() }
//    )
//}

@Preview
@Composable
fun TabBarComponentPreview() {
    TabBarComponent()
}