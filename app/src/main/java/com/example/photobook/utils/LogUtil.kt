package com.example.photobook.utils

import android.util.Log

class LogUtil {

    companion object {
        const val DEBUG_MODE = true

        fun d(message: String) {
            if (DEBUG_MODE) {
                var tag = ""
                val traceElement = Throwable().stackTrace[1]
                val temp = traceElement.className
                if (temp != null) {
                    val lastDotPos = temp.lastIndexOf(".")
                    if (((lastDotPos + 1) >= 0) && ((lastDotPos + 1) <= temp.length)) {
                        tag = temp.substring(lastDotPos + 1)
                    }
                }
                val methodName = traceElement.methodName
                val lineNumber = traceElement.lineNumber
                Log.d(getLogTag(), "[$tag] $methodName()[$lineNumber] >> $message")

            }
        }

        fun e(message: String) {
            if (DEBUG_MODE) {
                var tag = ""
                val traceElement = Throwable().stackTrace[1]
                val temp = traceElement.className
                if (temp != null) {
                    val lastDotPos = temp.lastIndexOf(".")
                    if (((lastDotPos + 1) >= 0) && ((lastDotPos + 1) <= temp.length)) {
                        tag = temp.substring(lastDotPos + 1)
                    }
                }
                val methodName = traceElement.methodName
                val lineNumber = traceElement.lineNumber
                Log.e(getLogTag(), "[$tag] $methodName()[$lineNumber] >> $message")
            }
        }

        fun getLogTag(): String {
            return "PHOTO_BOOK"
        }
    }

}