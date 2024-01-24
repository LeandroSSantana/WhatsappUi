package com.llsdc.whatsappui.model.calls

import com.llsdc.whatsappui.R

class CallContentModel {
    val callsList = listOf(
        CallModel(
            "Vegeta",
            "21 de Janeiro, ",
            "10:30",
            R.drawable.vegeta,
            R.drawable.ic_call_made
        ),
        CallModel(
            "Will Smith",
            "23 de janeiro, ",
            "14:35",
            R.drawable.will,
            R.drawable.ic_call_missed
        ),
    )
}