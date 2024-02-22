package com.abhay.demoproject.app

import android.app.Application
import com.abhay.demoproject.util.CommonSharedPref


class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        CommonSharedPref.initialise(this)
    }
}