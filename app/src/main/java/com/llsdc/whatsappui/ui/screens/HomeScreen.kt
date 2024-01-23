package com.llsdc.whatsappui.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.llsdc.whatsappui.ui.components.AppBarComponent
import com.llsdc.whatsappui.ui.components.TabBarComponent

@Composable
fun HomeScreen() {
    Column {
        AppBarComponent()
        TabBarComponent()
    }

}


@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
    TabBarComponent()
}