package com.pouyan.planner

import android.annotation.SuppressLint
import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var web: WebView

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        web = findViewById(R.id.web)
        web.settings.apply {
            javaScriptEnabled = true
            domStorageEnabled = true          // localStorage = ذخیره داده‌ها
            cacheMode = WebSettings.LOAD_DEFAULT
            allowFileAccess = true
            builtInZoomControls = false
            textZoom = 100                    // جلوگیری از تغییر اندازه با فونت سیستم
        }
        // back button = بازگشت داخلی صفحه، وگرنه خروج
        web.goBack()

        web.loadUrl("file:///android_asset/index.html")
    }

    override fun onBackPressed() {
        if (web.canGoBack()) web.goBack() else super.onBackPressed()
    }
}
