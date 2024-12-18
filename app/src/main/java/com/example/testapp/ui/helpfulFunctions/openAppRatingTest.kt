package com.example.testapp.ui.helpfulFunctions

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri


fun openAppRatingTest(context: Context) {

    val testPackageName = "com.pdfviewer.prodoc"
    val uri = Uri.parse("market://details?id=$testPackageName")
    val intent = Intent(Intent.ACTION_VIEW, uri).apply {
        addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY or
                Intent.FLAG_ACTIVITY_NEW_DOCUMENT or
                Intent.FLAG_ACTIVITY_MULTIPLE_TASK)
    }
    try {
        context.startActivity(intent)
    } catch (e: ActivityNotFoundException) {
        val webUri = Uri.parse("https://play.google.com/store/apps/details?id=$testPackageName")
        context.startActivity(Intent(Intent.ACTION_VIEW, webUri))
    }
}