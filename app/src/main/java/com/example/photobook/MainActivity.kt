package com.example.photobook

import android.os.Bundle
import androidx.activity.ComponentActivity
import com.example.photobook.utils.LogUtil

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        LogUtil.d("MainActivity onCreate()")
    }
}