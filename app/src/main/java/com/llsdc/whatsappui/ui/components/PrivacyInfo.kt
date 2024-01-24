package com.llsdc.whatsappui.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PrivacyInfoComponent() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        // Top text
        Text(
            text = "Your chats and calls are private",
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            color = Color.Black
        )

        // Spacer
        Spacer(modifier = Modifier.height(8.dp))

        // Second text
        Text(
            text = "End-to-end encryption keeps your personal messages and calls between you and people you choose. Not even WhatsApp can read or listen to them. This includes your:",
            fontSize = 14.sp,
            color = Color.Gray
        )

        // Spacer
        Spacer(modifier = Modifier.height(8.dp))

        // Icons and bullet points
        BulletPoint("Text and voice messages")
        BulletPoint("Audio and voice calls")
        BulletPoint("Photos, videos, and documents")
        BulletPoint("Location sharing")
        BulletPoint("Status updates")

        // Spacer
        Spacer(modifier = Modifier.height(16.dp))

        // Learn More
        LearnMoreLink()
    }
}

@Composable
private fun BulletPoint(text: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Icon (you can replace this with your own icon)
        Icon(
            imageVector = Icons.Default.Check,
            contentDescription = null,
            tint = Color.Green,
            modifier = Modifier.size(16.dp)
        )

        // Spacer
        Spacer(modifier = Modifier.width(4.dp))

        // Bullet point text
        Text(
            text = text,
            fontSize = 14.sp,
            color = Color.Gray
        )
    }
}

@Composable
private fun LearnMoreLink() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Learn More",
            fontSize = 14.sp,
            color = MaterialTheme.colorScheme.primary,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.clickable {
                // Implementar a lógica para abrir a URL ou realizar a ação desejada

            }
        )
    }
}
