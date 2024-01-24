package com.llsdc.whatsappui.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.llsdc.whatsappui.R
import com.llsdc.whatsappui.model.calls.CallModel
import com.llsdc.whatsappui.model.chat.ChatModel
import kotlinx.coroutines.launch

@Composable
fun ChatItemRowComponent(chatItem: ChatModel) {
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
                color = Gray
            )

            Spacer(modifier = Modifier.height(4.dp))

            // Mute icon
            if (chatItem.isMuted) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_volume_of),
                    contentDescription = null,
                    tint = Gray,
                    modifier = Modifier.size(16.dp)
                )
            }
        }
    }
}

@Composable
fun CallItemRowComponent(callItem: CallModel) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Circular image
        Image(
            painter = painterResource(id = callItem.profileImageResId),
            contentDescription = null,
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape)
        )

        Spacer(modifier = Modifier.width(8.dp))

        // Chat details
        Column {
            // Name
            Text(
                text = callItem.name,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )

            Spacer(modifier = Modifier.height(4.dp))

            Row {
                Icon(
                    painter = painterResource(id = callItem.iconCall),
                    contentDescription = null,
                    tint = Color(callItem.iconColor)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = callItem.date,
                    overflow = TextOverflow.Ellipsis,
                    fontSize = 16.sp

                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = callItem.timestamp,
                    overflow = TextOverflow.Ellipsis,
                    fontSize = 16.sp,
                )
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    painter = painterResource(id = R.drawable.ic_call),
                    contentDescription = null,
                    tint = Gray,
                    modifier = Modifier.size(28.dp)
                )
            }
        }

        Spacer(modifier = Modifier.weight(1f))
    }
}

@Composable
fun TextEncryptedComponent() {
    val coroutineScope = rememberCoroutineScope()

    var showDialog by remember { mutableStateOf(false) }

    // Função para exibir o Dialog
    fun showAlertDialog() {
        showDialog = true
    }

    if (showDialog) {
        AlertDialog(
            onDismissRequest = {
                showDialog = false
            },
            text = {
                PrivacyInfoComponent()
            },
            confirmButton = {
            },
            dismissButton = {
            }
        )
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.Absolute.Center,
    ) {
        Icon(
            imageVector = Icons.Default.Lock,
            contentDescription = null,
            modifier = Modifier.size(18.dp),
            tint = Gray
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = "Your personal messages are ",
            color = Gray,
            style = TextStyle(fontSize = 14.sp)
        )
        ClickableText(
            text = AnnotatedString.Builder().apply {
                withStyle(
                    style = SpanStyle(
                        color = MaterialTheme.colorScheme.primary,
                        fontSize = 14.sp
                    )
                ) {
                    append("end-to-end encrypted")
                }
            }.toAnnotatedString(),
            onClick = {
                coroutineScope.launch {
                    showAlertDialog()
                }
            }
        )
    }
}


