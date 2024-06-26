package com.example.photobook

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.photobook.ui.edit.AddPhoto
import com.example.photobook.utils.LogUtil
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        LogUtil.d("MainActivity onCreate()")
        setContent {
//            PhotoBookApp()
            AddPhoto()
        }
    }
}