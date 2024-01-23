package com.llsdc.whatsappui.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.llsdc.whatsappui.R
import com.llsdc.whatsappui.model.chat.ChatContentModel
import com.llsdc.whatsappui.model.chat.ChatModel

@Composable
fun ChatsContentTab(chatList: List<ChatModel>, onFabClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        LazyColumn {
            items(chatList) { chatItem ->
                ChatItemRow(chatItem)
                Divider(thickness = 0.5.dp)
            }
        }

        // Adiciona o FloatingActionButton no canto inferior direito
        FloatingActionButton(
            onClick = { onFabClick() },
            shape = CircleShape,
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.BottomEnd),
            containerColor = MaterialTheme.colorScheme.primary
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_chat),
                contentDescription = null,
                tint = MaterialTheme.colorScheme.tertiary
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatItemRow(chatItem: ChatModel) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Circular image
        Image(
            painter = painterResource(id = chatItem.profileImageResId),
            contentDescription = null,
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape)
        )

        Spacer(modifier = Modifier.width(16.dp))

        // Chat details
        Column {
            // Name
            Text(
                text = chatItem.name,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )

            Spacer(modifier = Modifier.height(4.dp))

            // Last message
            Text(
                text = chatItem.lastMessage,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        // Chat info (time, notification, mute)
        Column(
            horizontalAlignment = Alignment.End,
            verticalArrangement = Arrangement.Center
        ) {

            // Time
            Text(
                text = chatItem.timestamp,
                fontSize = 12.sp,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(4.dp))

            // Mute icon
            if (chatItem.isMuted) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_volume_of),
                    contentDescription = null,
                    tint = Color.Gray,
                    modifier = Modifier.size(16.dp)
                )
            }
        }
    }
}

@Preview
@Composable
fun ChatContentTabPreview() {
    val chatContentModel = ChatContentModel()
    ChatsContentTab(chatContentModel.chatList) { }
}
