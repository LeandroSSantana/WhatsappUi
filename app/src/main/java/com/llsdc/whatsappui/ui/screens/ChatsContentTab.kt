package com.llsdc.whatsappui.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Divider
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.llsdc.whatsappui.R
import com.llsdc.whatsappui.model.chat.ChatContentModel
import com.llsdc.whatsappui.model.chat.ChatModel
import com.llsdc.whatsappui.ui.components.ChatItemRowComponent
import com.llsdc.whatsappui.ui.components.TextEncryptedComponent

@Composable
fun ChatsContentTab(chatList: List<ChatModel>, onFabClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        LazyColumn {
            items(chatList) { chatItem ->
                ChatItemRowComponent(chatItem)
                Divider(thickness = 0.5.dp)
            }
            item {
                TextEncryptedComponent()
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

@Preview
@Composable
fun ChatContentTabPreview() {
    val chatContentModel = ChatContentModel()
    ChatsContentTab(chatContentModel.chatList) { }
}
