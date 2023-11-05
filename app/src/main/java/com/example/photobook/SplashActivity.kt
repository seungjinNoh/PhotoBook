package com.example.photobook

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.photobook.utils.LogUtil

class SplashActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val permissions = arrayOf(
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.ACCESS_FINE_LOCATION
        )

        if (checkPermissions(permissions)) {
            LogUtil.d("권한이 이미 부여됨")
        } else {
            requestPermissions(permissions)
        }

    }

    private fun checkPermissions(permissions: Array<String>): Boolean {
        val grantedPermissions = permissions.filter {
            ContextCompat.checkSelfPermission(this, it) == PackageManager.PERMISSION_GRANTED
        }
        return grantedPermissions.size == permissions.size
    }

    private fun requestPermissions(permissions: Array<String>) {
        ActivityCompat.requestPermissions(this, permissions, PERMISSION_REQUEST_CODE)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == PERMISSION_REQUEST_CODE) {
            if (grantResults.all { it == PackageManager.PERMISSION_GRANTED }) {
                // 모든 권한이 허용됨
                LogUtil.d("모든 권한이 허용됨")
            } else {
                // 권한이 거부됨
                LogUtil.d("권한이 거부됨")
            }
        }
    }

    companion object {
        private const val PERMISSION_REQUEST_CODE = 1
    }
}