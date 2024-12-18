package com.example.testapp.ui.helpfulFunctions


import android.content.Context
import android.content.Intent

fun shareApp(context: Context) {
    val appPackageName = context.packageName
    val shareIntent = Intent().apply {
        action = Intent.ACTION_SEND
        type = "text/plain"
        putExtra(Intent.EXTRA_SUBJECT, "Check out this app!")
        putExtra(
            Intent.EXTRA_TEXT,
            "Hey, check out this amazing app: https://play.google.com/store/apps/details?id=$appPackageName"
        )
    }
    context.startActivity(Intent.createChooser(shareIntent, "Share via"))
}
