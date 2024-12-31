package org.wizard.project.utils

import android.util.Log

private const val TAG = "Logger.android"
actual fun logMessage(message: String) {

    Log.d(TAG, "logMessage: $message")
}