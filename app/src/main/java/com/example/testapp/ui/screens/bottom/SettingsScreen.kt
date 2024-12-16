package com.example.testapp.ui.screens.bottom

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testapp.R
import com.example.testapp.data.DataStoreManager
import com.example.testapp.ui.helpfulFunctions.ChangeStatusBarColor
import com.example.testapp.uikit.common.BlackColor
import com.example.testapp.uikit.common.GreenColor
import com.example.testapp.uikit.common.RedColor
import com.example.testapp.uikit.common.WhiteColor
import com.example.testapp.uikit.settingsRow.MySettingsRow
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun SettingsScreen(
    dataStoreManager: DataStoreManager,
) {
    ChangeStatusBarColor(color = WhiteColor, isIconsLight = false)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = WhiteColor),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start,
    ) {
        Text(
            modifier = Modifier
                .padding(start = 16.dp, top = 64.dp, end = 16.dp, bottom = 16.dp),
            text = "Settings",
            fontSize = 34.sp,
            fontWeight = FontWeight.ExtraBold,
            color = BlackColor
        )
        HorizontalDivider()

        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                MySettingsRow(
                    iconRes = R.drawable.usage_policy,
                    iconTint = GreenColor,
                    text = "Usage Policy",
                )
                MySettingsRow(
                    iconRes = R.drawable.share_our_app,
                    iconTint = GreenColor,
                    text = "Share our app",
                )
                MySettingsRow(
                    iconRes = R.drawable.rate_app,
                    iconTint = GreenColor,
                    text = "Rate app",
                )
            }

            MySettingsRow(
                iconRes = R.drawable.reset_progress,
                iconTint = RedColor,
                text = "Reset progress",
                onClick = {
                    CoroutineScope(Dispatchers.IO).launch {
                        dataStoreManager.clearSelectedLessons()
                    }
                }
            )
        }
    }
}

@Composable
@Preview
private fun SettingsScreenPreview() {
    val context = LocalContext.current
    val dataStoreManager = DataStoreManager(context)
    SettingsScreen(dataStoreManager = dataStoreManager)
}