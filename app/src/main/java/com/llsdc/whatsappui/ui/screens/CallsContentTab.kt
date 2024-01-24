package com.llsdc.whatsappui.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.llsdc.whatsappui.R
import com.llsdc.whatsappui.model.calls.CallContentModel
import com.llsdc.whatsappui.model.calls.CallModel
import com.llsdc.whatsappui.ui.components.CallItemRowComponent
import com.llsdc.whatsappui.ui.components.TextEncryptedComponent

@Composable
fun CallsContentTab(callsList: List<CallModel>, onFabClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        LazyColumn {
            items(callsList) { callsItem ->
                CallItemRowComponent(callsItem)
                Divider(thickness = 0.5.dp)
            }

            item {
                TextEncryptedComponent()
            }
        }

        FloatingActionButton(
            onClick = { onFabClick() },
            shape = CircleShape,
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.BottomEnd),
            containerColor = MaterialTheme.colorScheme.primary
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_make_call),
                contentDescription = null,
                tint = MaterialTheme.colorScheme.tertiary
            )
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun CallsContentTabPreview() {
    val callsModel = CallContentModel()
    val callsList = callsModel.callsList

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        CallsContentTab(callsList = callsList, onFabClick = {})
    }
}