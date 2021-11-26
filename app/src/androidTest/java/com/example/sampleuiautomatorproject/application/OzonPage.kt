package com.example.sampleuiautomatorproject.application
import com.example.sampleuiautomatorproject.util.*
import com.example.sampleuiautomatorproject.util.ext.*
import androidx.test.uiautomator.UiScrollable
import androidx.test.uiautomator.UiSelector


class OzonPage : AbstractApplication("ru.ozon.app.android") {

    private val popUp = byResId("ru.ozon.app.android:id/titleTv")
    private val historyBlock = byResId("ru.ozon.app.android:id/shadowIv")
    private val searchButton = byResId("ru.ozon.app.android:id/searchTv")
    private val searchInputSelector = byResId("ru.ozon.app.android:id/search_src_text")
    private val bookDesc = byText("Философия Java. 4-е полное изд.")
    private val bookPrice = byResId("ru.ozon.app.android:id/priceTv")

    //Locators for second test
    private val goInHint = byText("Философия Java. 4-е полное изд.")
    private val heartButton = byResId("ru.ozon.app.android:id/favIcon")
    private val favoriteMenu = byResId("ru.ozon.app.android:id/menu_favorites")

    //Locators for third test
    private val profileMenu = byResId("ru.ozon.app.android:id/menu_profile")
    private val signInOrRegister = byResId("ru.ozon.app.android:id/buttonAtomTitleTv")
    private val signInByEmail = byResId("ru.ozon.app.android:id/hintButtonsContainerLl")
    private val emailInputSelector = byResId("ru.ozon.app.android:id/fieldEt")
    private val getCode = byResId("ru.ozon.app.android:id/submitBtn")
    private val errorEmailLabel =  byResId("ru.ozon.app.android:id/textinput_error")

    //Locators for fourth test
    private val writeFeedback = byResId("ru.ozon.app.android:id/buttonAtomTitleTv")
    private val signInScreen = byText("Вход или регистрация")


    //General methods for all tests
    fun hidePopUpOrHistory(){
        if (popUp.waitHasObject() || historyBlock.waitHasObject()){
            device.pressBack()
        }
    }

    fun clickSearch() {
        searchButton.waitFindObject().click()
    }

    fun typeToSearch(text: String) {
        searchInputSelector.waitFindObject().text = text

    }


    //Main methods for first test
    fun bookInfo():Boolean = bookDesc.waitHasObject() && bookPrice.waitHasObject()


    //Methods for second test
    fun goHint() {
        goInHint.waitFindObject().click()

    }

    fun addToFav() {
        heartButton.waitFindObject().click()

    }

    fun goToFav() {
        favoriteMenu.waitFindObject().click()
    }

    fun checkFavorites():Boolean = favoriteMenu.waitFindObject().isEnabled


    //Methods for third test
    fun goToMyOzon() {
        profileMenu.waitFindObject().click()
    }

    fun logInByEmail() {
        signInOrRegister.waitFindObject().click()
        signInByEmail.waitFindObject().click()
    }

    fun typeWrongEmail(text: String) {
        emailInputSelector.waitFindObject().text = text
        getCode.waitFindObject().click()

    }

    fun emailError():Boolean = errorEmailLabel.waitFindObject().isEnabled

    //Methods for fourth test
    fun scrollToFeedbacks() {
        val listView = UiScrollable(UiSelector().scrollable(true))
        listView.scrollTextIntoView("Написать отзыв")
    }

    fun writeFeedback() {
        writeFeedback.waitFindObject().click()

    }

    fun checkFeedsScreen():Boolean = signInScreen.waitFindObject().isEnabled




}