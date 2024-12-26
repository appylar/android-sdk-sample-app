package com.appylar.android.appylarsampleapp

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.appylar.android.sdk.bannerview.BannerView
import com.appylar.android.sdk.bannerview.BannerViewListener
import com.appylar.android.sdk.interstitial.Interstitial
import com.appylar.android.sdk.interstitial.InterstitialListener

class KotlinActivity : AppCompatActivity(), BannerViewListener, InterstitialListener {
    private val tag = "AppylarSampleApp"
    private lateinit var bannerView: BannerView
    private lateinit var btnShowBanner: Button
    private lateinit var btnHideBanner: Button
    private lateinit var btnShowInterstitial: Button

    companion object {
        private lateinit var statusView: TextView
        fun updateStatusText(text: String){
            statusView.text = text
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bannerView = findViewById(R.id.bannerView)
        btnShowBanner = findViewById(R.id.btnShowBanner)
        btnHideBanner = findViewById(R.id.btnHideBanner)
        btnShowInterstitial = findViewById(R.id.btnShowInterstitial)
        statusView = findViewById(R.id.statusView)

        // Set event listener for the banner view
        bannerView.setEventListener(this)

        // Attach banner button click listener
        btnShowBanner.setOnClickListener {
            //if (bannerView.canShowAd()) {
                bannerView.showAd()
            //}
        }
        btnHideBanner.setOnClickListener {
            bannerView.hideAd()
        }

        // Set event listener for the interstitial
        Interstitial.setEventListener(this) // Attach interstitial event listeners

        // Attach interstitial button click listener
        btnShowInterstitial.setOnClickListener {
            //if (Interstitial.canShowAd()) {
                Interstitial.showAd(this)
            //}
        }
    }

    // Event listener triggered when a banner is shown for the parameter height
    override fun onBannerShown(height: Int) {
        Log.d(tag, "onBannerShown($height)")
        updateStatusText("")
    }

    // Event listener triggered when there are no banners to show
    override fun onNoBanner() {
        Log.d(tag, "onNoBanner()")
        updateStatusText("No more banners in the buffer,\nplease retry again after a minute.")
    }

    // Event listener triggered when an interstitial is shown
    override fun onInterstitialShown() {
        Log.d(tag, "onInterstitialShown()")
        updateStatusText("")
    }

    // Event listener triggered when an interstitial is closed
    override fun onInterstitialClosed() {
        Log.d(tag, "onInterstitialClosed()")
        updateStatusText("")
    }

    // Event listener triggered when there are no interstitials to show
    override fun onNoInterstitial() {
        Log.d(tag, "onNoInterstitial()")
        updateStatusText("No more interstitials in the buffer,\nplease retry again after a minute.")
    }
}