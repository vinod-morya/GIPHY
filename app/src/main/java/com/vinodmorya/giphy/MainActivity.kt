package com.vinodmorya.giphy

import am.appwise.components.ni.NoInternetDialog
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.vinodmorya.giphy.ui.support.networkState.NetworkStateReceiver
import com.google.android.material.tabs.TabLayout
import com.vinodmorya.giphy.ui.support.SimpleFragmentPagerAdapter


class MainActivity : AppCompatActivity(), NetworkStateReceiver.NetworkStateReceiverListener {

    private lateinit var noInternetDialog: NoInternetDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {

            noInternetDialog = NoInternetDialog.Builder(this).setCancelable(true).setDialogRadius(20f).build()
            val viewPager = findViewById<View>(R.id.vp_main) as ViewPager
            val adapter = SimpleFragmentPagerAdapter(this, supportFragmentManager)
            viewPager.adapter = adapter
            val tabLayout = findViewById<View>(R.id.tl_main) as TabLayout
            tabLayout.setupWithViewPager(viewPager)
        }
    }

    override fun networkAvailable() {
        noInternetDialog.hide()
    }

    override fun networkUnavailable() {
        noInternetDialog.showDialog()
    }

    override fun onDestroy() {
        super.onDestroy()
        noInternetDialog.onDestroy()
    }
}
