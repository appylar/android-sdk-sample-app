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
        Appylar.setEventListener(this) //Attach callback listeners for SDK before initialization
        Appylar.init(
            this, //Application context
            "jrctNFE1b-7IqHPShB-gKw",    //APP KEY provide by console for Development use ["jrctNFE1b-7IqHPShB-gKw"]
            arrayOf(AdType.BANNER, AdType.INTERSTITIAL),    //What type of Ads you want to integrate
            arrayOf(
                Orientation.PORTRAIT,
                Orientation.LANDSCAPE
            ),    //Supported orientations for Ads
            true    //Test Mode, [TRUE] for development & [FALSE] for production
        )
    }

    override fun onError(error: String) {
        Log.d(TAG, "onError: $error")
    }

    override fun onInitialized() {
        Log.d(TAG, "onInitialized: called")
    }
}