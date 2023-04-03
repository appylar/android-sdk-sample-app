package com.appylar.android.androidsamplekotlin

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.appylar.android.sdk.bannerview.BannerView
import com.appylar.android.sdk.bannerview.BannerViewListener
import com.appylar.android.sdk.interstitial.Interstitial
import com.appylar.android.sdk.interstitial.InterstitialListener

class KotlinActivity : AppCompatActivity(), BannerViewListener, InterstitialListener {
    private val TAG = "KotlinActivity"
    private lateinit var bannerView: BannerView
    private lateinit var btnShowBanner: Button
    private lateinit var btnHideBanner: Button
    private lateinit var btnShowInterstitial: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bannerView = findViewById(R.id.bannerView)
        btnShowBanner = findViewById(R.id.btnShowBanner)
        btnHideBanner = findViewById(R.id.btnHideBanner)
        btnShowInterstitial = findViewById(R.id.btnShowInterstitial)

        bannerView.setEventListener(this) //Attach Banner Event Listeners
        btnShowBanner.setOnClickListener {
            if (bannerView.canShowAd()) {
                bannerView.showAd()
            }
        }
        btnHideBanner.setOnClickListener {
            bannerView.hideBanner()
        }

        Interstitial.setEventListener(this) //Attach Interstitial Event Listeners
        btnShowInterstitial.setOnClickListener {
            if (Interstitial.canShowAd()) {
                Interstitial.showAd(this)
            }
        }
    }

    override fun onInterstitialClosed() {
        Log.d(TAG, "onInterstitialClosed: called")
    }

    override fun onInterstitialShown() {
        Log.d(TAG, "onInterstitialShown: called")
    }

    override fun onNoInterstitial() {
        Log.d(TAG, "onNoInterstitial: called")
    }

    override fun onBannerShown() {
        Log.d(TAG, "onBannerShown: called")
    }

    override fun onNoBanner() {
        Log.d(TAG, "onNoBanner: called")
    }
}