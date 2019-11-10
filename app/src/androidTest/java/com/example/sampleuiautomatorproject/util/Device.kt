package com.example.sampleuiautomatorproject.util

import android.content.Context
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.UiDevice

val device: UiDevice
    get() = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())

val context: Context
    get() = InstrumentationRegistry.getInstrumentation().context