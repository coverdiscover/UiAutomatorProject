package com.example.sampleuiautomatorproject.util.ext

import java.util.concurrent.TimeUnit

fun Int.secondsToMillis(): Long = TimeUnit.SECONDS.toMillis(this.toLong())
