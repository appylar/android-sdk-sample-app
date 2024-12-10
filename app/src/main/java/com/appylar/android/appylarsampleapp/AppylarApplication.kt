package com.appylar.android.appylarsampleapp

import android.app.Application
import android.util.Log
import com.appylar.android.sdk.Appylar
import com.appylar.android.sdk.enums.AdType
import com.appylar.android.sdk.interfaces.Events

class AppylarApplication : Application(), Events {
    private val tag = "AppylarSampleApp"

    override fun onCreate() {
        super.onCreate()

        // Set event listener before initialization
        Appylar.setEventListener(this)

        // Initialize
        Appylar.init(
            this, // The application context
            "<YOUR_ANDROID_APP_KEY>", // The unique app key for your app
            arrayOf(AdType.BANNER, AdType.INTERSTITIAL), // The ad types that you want to show
            true // Test mode, true for development, false for production
        )
    }

    // Event listener triggered if an error occurs in the SDK
    override fun onError(error: String) {
        Log.d(tag, "onError(): $error")
    }

    // Event listener triggered at successful initialization
    override fun onInitialized() {
        Log.d(tag, "onInitialized()")
    }
}