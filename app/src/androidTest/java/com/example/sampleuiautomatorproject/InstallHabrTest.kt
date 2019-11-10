package com.example.sampleuiautomatorproject

import android.content.Intent
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.uiautomator.By
import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.Until

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class InstallHabrTest {
    companion object {
        const val TIMEOUT = 5000L
    }
    private val device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())
    private val context = InstrumentationRegistry.getInstrumentation().context

    @Before
    fun setUp() {
        val intent =
            context.packageManager.getLaunchIntentForPackage("com.android.vending")?.apply {
                addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            }
        device.pressHome()
        context.startActivity(intent)
    }

    @Test
    fun installHabr() {
        device.wait(
            Until.findObject(By.res("com.android.vending:id/search_bar_hint")),
            TIMEOUT
        ).click()
        device.wait(
            Until.findObject(By.res("com.android.vending:id/search_bar_text_input")),
            TIMEOUT
        ).text = "Habrahabr"
        device.wait(
            Until.findObject(By.text("Habr — сообщество IT-специалистов")),
            TIMEOUT
        ).click()
        device.wait(
            Until.findObject(By.text("Установить")),
            TIMEOUT
        ).click()
        val isInstalled = device.wait(
            Until.findObject(By.text("Открыть")),
            TIMEOUT
        ).wait(Until.clickable(true), 20000L)
        assertTrue("Приложение не установилось", isInstalled)
        device.findObject(By.text("Открыть")).click()
    }
}
