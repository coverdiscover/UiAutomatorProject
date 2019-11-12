package com.example.sampleuiautomatorproject.util.ext

import androidx.test.uiautomator.BySelector
import androidx.test.uiautomator.UiObject2
import androidx.test.uiautomator.Until
import com.example.sampleuiautomatorproject.util.device

private val defaultTimeout = 10.secondsToMillis()

fun BySelector.findObject(): UiObject2 {
    return device.findObject(this)
}

fun BySelector.waitFindObject(timeout: Long = defaultTimeout): UiObject2 {
    return device.wait(Until.findObject(this), timeout)
}

fun BySelector.waitFindObjects(timeout: Long = defaultTimeout): List<UiObject2> {
    return device.wait(Until.findObjects(this), timeout)
}

fun BySelector.waitHasObject(timeout: Long = defaultTimeout): Boolean {
    return device.wait(Until.hasObject(this), timeout)
}

fun BySelector.waitUntillGone(timeout: Long = defaultTimeout): Boolean {
    return device.wait(Until.gone(this), timeout)
}

fun BySelector.hasObject(): Boolean {
    return device.hasObject(this)
}

fun UiObject2.waitIsClickable(isClickable: Boolean, timeout: Long = defaultTimeout): Boolean {
    return this.wait(Until.clickable(isClickable), timeout)
}

fun UiObject2.clickAndWaitnewWindow(timeout: Long = defaultTimeout): Boolean {
    return this.clickAndWait(Until.newWindow(), timeout)
}