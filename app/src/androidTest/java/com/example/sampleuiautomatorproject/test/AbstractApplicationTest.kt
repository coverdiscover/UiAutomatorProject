package com.example.sampleuiautomatorproject.test

import android.util.Log
import com.example.sampleuiautomatorproject.application.AbstractApplication
import com.example.sampleuiautomatorproject.util.device
import org.junit.Before

abstract class AbstractApplicationTest(val app : AbstractApplication) {

    @Before
    fun assertPackageInstalled() {
        app.assertInstalled()
    }

    @Before
    fun clearCache() {
        device.executeShellCommand("pm clear ${app.packageName}")
        Log.d("Selector", "Cache clear")
    }
}