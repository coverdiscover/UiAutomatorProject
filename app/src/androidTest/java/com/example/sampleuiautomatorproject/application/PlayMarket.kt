package com.example.sampleuiautomatorproject.application

import com.example.sampleuiautomatorproject.util.byStringRes
import com.example.sampleuiautomatorproject.util.byText
import com.example.sampleuiautomatorproject.util.ext.*
import org.junit.Assert.assertTrue

import com.example.sampleuiautomatorproject.util.device

class PlayMarket : AbstractApplication("com.android.vending") {

    //private val searchSelector = byStringRes("com.android.vending:id/search_bar_hint")
    private val searchSelector = byText("Поиск игр и приложений")
    //private val searchInputSelector = byStringRes("com.android.vending:id/search_bar_text_input")
    private val searchInputSelector = byText("Поиск игр и приложений")
    private val installButton = byText("Установить")
    private val openInstalledAppButton = byText("Открыть")

    fun clickSearch() {
        searchSelector.waitFindObject().click()
    }

    fun typeToSearch(text: String) {
        searchInputSelector.waitFindObject().text = text
    }

    fun pressEnt() {
       device.pressEnter()
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

    fun openApp() {
        openInstalledAppButton.findObject().clickAndWaitnewWindow()
    }
}
