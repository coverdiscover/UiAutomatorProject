package com.example.sampleuiautomatorproject.util

import androidx.test.uiautomator.By

fun byStringRes(stringRes: String) = By.res(stringRes)

fun byText(text: String) = By.text(text)

fun byClass(className: String) = By.clazz(className)

fun byResId(resourceId: String) = By.res(resourceId)

