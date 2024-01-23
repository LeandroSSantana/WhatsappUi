package com.llsdc.whatsappui.model.chat

data class ChatModel(
    val name: String,
    val lastMessage: String,
    val timestamp: String,
    val hasNotification: Boolean,
    val isMuted: Boolean,
    val notificationCount: Int,
    val profileImageResId: Int
)