package com.llsdc.whatsappui.model.calls

import android.graphics.Color
import com.llsdc.whatsappui.R

data class CallModel(
    val name: String,
    val date: String,
    val timestamp: String,
    val profileImageResId: Int,
    val iconCall: Int
) {
    val iconColor: Int
        get() = when (iconCall) {
            R.drawable.ic_call_made -> Color.GREEN
            R.drawable.ic_call_received -> Color.BLUE
            R.drawable.ic_call_missed -> Color.RED
            else -> Color.GRAY
        }
}

