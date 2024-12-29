package com.example.testapp.ui.screens.bottom

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import com.example.testapp.ui.helpfulFunctions.openAppRating
import com.example.testapp.ui.helpfulFunctions.openUrl
import com.example.testapp.ui.helpfulFunctions.shareApp
import com.example.testapp.uikit.common.BlackColor
import com.example.testapp.uikit.common.BlueColor2
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
    var showDialog by remember { mutableStateOf(false) }
    val context = LocalContext.current

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
                    iconTint = BlueColor2,
                    text = "Usage Policy",
                    onClick = {
                        val privacyPolicyUrl =
                            "https://doc-hosting.flycricket.io/divepo-changequiz-privacy-policy/6fefacd5-c4d1-49f1-afab-ca0e0281e456/privacy"
                        openUrl(context, privacyPolicyUrl)
                    }
                )
                MySettingsRow(
                    iconRes = R.drawable.share_our_app,
                    iconTint = BlueColor2,
                    text = "Share our app",
                    onClick = {
                        shareApp(context)
                    }
                )
                MySettingsRow(
                    iconRes = R.drawable.rate_app,
                    iconTint = BlueColor2,
                    text = "Rate app",
                    onClick = {
                        openAppRating(context)
                    }
                )
            }

            MySettingsRow(
                iconRes = R.drawable.reset_progress,
                iconTint = RedColor,
                text = "Reset progress",
                onClick = {
                    showDialog = true
                }
            )
        }
    }
    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            title = { Text(text = "Confirm Reset") },
            text = { Text("Are you sure you want to reset the progress? This action cannot be undone.") },
            confirmButton = {
                TextButton(
                    onClick = {
                        CoroutineScope(Dispatchers.IO).launch {
                            dataStoreManager.clearSelectedLessons()
                        }
                        showDialog = false
                    }
                ) {
                    Text("Yes")
                }
            },
            dismissButton = {
                TextButton(onClick = { showDialog = false }) {
                    Text("No")
                }
            }
        )
    }
}

@Composable
@Preview
private fun SettingsScreenPreview() {
    val context = LocalContext.current
    val dataStoreManager = DataStoreManager(context)
    SettingsScreen(dataStoreManager = dataStoreManager)
}