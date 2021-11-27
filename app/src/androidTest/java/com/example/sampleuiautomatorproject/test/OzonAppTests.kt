package com.example.sampleuiautomatorproject.test

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.sampleuiautomatorproject.application.OzonPage
import com.example.sampleuiautomatorproject.application.PlayMarket
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Assert.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class OzonAppTests: AbstractApplicationTest<OzonPage>(OzonPage()) {

    @Before
    fun untilBookSearch() = with(app) {
        open()
        hidePopUpOrHistory()

    }

    @Test
    fun checkingHintTest() = with(app) {
        clickSearch()
        typeToSearch("философия java")
        val bookInfoResult = bookInfo()
        assertTrue(bookInfoResult)

    }


    @Test
    fun addItemToFavorite() = with(app) {
        clickSearch()
        typeToSearch("философия java")
        goHint()
        addToFav()
        hidePopUpOrHistory()
        goToFav()
        assertTrue(checkFavorites())

    }

    @Test
    fun checkEmailValidation() = with(app) {
        goToMyOzon()
        logInByEmail()
        typeWrongEmail("kek")
        assertTrue(emailError())

    }

    @Test
    fun feedbacksForRegistered() = with(app) {
        clickSearch()
        typeToSearch("философия java")
        goHint()
        scrollToFeedbacks()
        writeFeedback()
        assertTrue(checkFeedsScreen())

    }


}
