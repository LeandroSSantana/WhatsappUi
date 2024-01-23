package com.llsdc.whatsappui.model.chat

data class ChatModel(
    val name: String,
    val lastMessage: String,
    val timestamp: String,
    val isMuted: Boolean,
    val profileImageResId: Int
)