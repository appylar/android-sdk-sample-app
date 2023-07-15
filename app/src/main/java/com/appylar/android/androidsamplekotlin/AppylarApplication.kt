package com.appylar.android.androidsamplekotlin

import android.app.Application
import android.util.Log
import com.appylar.android.sdk.Appylar
import com.appylar.android.sdk.enums.AdType
import com.appylar.android.sdk.enums.Orientation
import com.appylar.android.sdk.interfaces.Events

class AppylarApplication : Application(), Events {
    private val TAG = "AppylarApplication"

    override fun onCreate() {
        super.onCreate()

        // Set event listener before initialization
        Appylar.setEventListener(this)

        // Initialize
        Appylar.init(
            this, // The application context
            "jrctNFE1b-7IqHPShB-gKw", // The unique app key for your app
            arrayOf(AdType.BANNER, AdType.INTERSTITIAL), // The ad types that you want to show
            arrayOf( Orientation.PORTRAIT, Orientation.LANDSCAPE),    //REMOVE THIS LINE!
            true // Test mode, true for development, false for production
        )
    }

    // Event listener triggered if an error occurs in the SDK
    override fun onError(error: String) {
        Log.d(TAG, "onError: $error")
    }

    // Event listener triggered at successful initialization
    override fun onInitialized() {
        Log.d(TAG, "onInitialized")
    }
}