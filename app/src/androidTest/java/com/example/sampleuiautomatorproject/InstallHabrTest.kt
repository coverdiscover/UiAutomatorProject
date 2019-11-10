package com.example.sampleuiautomatorproject

import android.content.Intent
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.sampleuiautomatorproject.util.byStringRes
import com.example.sampleuiautomatorproject.util.byText
import com.example.sampleuiautomatorproject.util.context
import com.example.sampleuiautomatorproject.util.device
import com.example.sampleuiautomatorproject.util.ext.*
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class InstallHabrTest {

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
        byStringRes("com.android.vending:id/search_bar_hint")
            .waitFindObject()
            .click()
        byStringRes("com.android.vending:id/search_bar_text_input")
            .waitFindObject()
            .text = "Habrahabr"
        byText("Habr — сообщество IT-специалистов")
            .waitFindObject()
            .click()
        byText("Установить")
            .waitFindObject()
            .click()
        val isInstalled = byText("Открыть")
            .waitFindObject()
            .waitIsClickable(true, 20.secondsToMillis())
        assertTrue("Приложение не установилось", isInstalled)
        byText("Открыть")
            .findObject()
            .clickAndWaitnewWindow()
    }
}
