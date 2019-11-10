package com.example.sampleuiautomatorproject.application

import android.content.Intent
import com.example.sampleuiautomatorproject.util.byStringRes
import com.example.sampleuiautomatorproject.util.byText
import com.example.sampleuiautomatorproject.util.context
import com.example.sampleuiautomatorproject.util.device
import com.example.sampleuiautomatorproject.util.ext.*
import org.junit.Assert.assertTrue

class PlayMarket {

    fun open() {
        val intent =
            context.packageManager.getLaunchIntentForPackage("com.android.vending")?.apply {
                addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            }
        device.pressHome()
        context.startActivity(intent)
    }

    fun clickSearch() {
        byStringRes("com.android.vending:id/search_bar_hint")
            .waitFindObject()
            .click()
    }

    fun typeToSearch(text: String) {
        byStringRes("com.android.vending:id/search_bar_text_input")
            .waitFindObject()
            .text = text
    }

    fun clickResult(resultName: String) {
        byText(resultName)
            .waitFindObject()
            .click()
    }

    fun clickInstall() {
        byText("Установить")
            .waitFindObject()
            .click()
    }

    fun waitForInstalled() {
        assertTrue(
            "Приложение не было установлено",
            byText("Открыть")
                .waitFindObject()
                .waitIsClickable(true, 20.secondsToMillis())
        )
    }

    fun openInstalledApp() {
        byText("Открыть")
            .findObject()
            .clickAndWaitnewWindow()
    }
}