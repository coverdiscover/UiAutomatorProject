package com.example.sampleuiautomatorproject.application

import android.content.Intent
import com.example.sampleuiautomatorproject.util.byStringRes
import com.example.sampleuiautomatorproject.util.byText
import com.example.sampleuiautomatorproject.util.context
import com.example.sampleuiautomatorproject.util.device
import com.example.sampleuiautomatorproject.util.ext.*
import org.junit.Assert.assertTrue

class PlayMarket {

    private val searchSelector = byStringRes("com.android.vending:id/search_bar_hint")
    private val searchInputSelector = byStringRes("com.android.vending:id/search_bar_text_input")
    private val installButton = byText("Установить")
    private val openInstalledAppButton = byText("Открыть")

    fun open() {
        val intent =
            context.packageManager.getLaunchIntentForPackage("com.android.vending")?.apply {
                addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            }
        device.pressHome()
        context.startActivity(intent)
    }

    fun clickSearch() {
        searchSelector.waitFindObject().click()
    }

    fun typeToSearch(text: String) {
        searchInputSelector.waitFindObject().text = text
    }

    fun clickResult(resultName: String) {
        byText(resultName).waitFindObject().click()
    }

    fun clickInstall() {
        installButton.waitFindObject().click()
    }

    fun waitForInstalled() {
        assertTrue(
            "Приложение не было установлено",
            openInstalledAppButton
                .waitFindObject()
                .waitIsClickable(true, 20.secondsToMillis())
        )
    }

    fun openInstalledApp() {
        openInstalledAppButton.findObject().clickAndWaitnewWindow()
    }
}
