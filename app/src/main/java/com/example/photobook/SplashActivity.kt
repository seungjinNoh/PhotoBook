package com.example.photobook

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.result.contract.ActivityResultContracts
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
            startMainActivity()
            LogUtil.d("권한이 이미 부여됨")
        } else {
            requestPermissions.launch(permissionList)
        }

    }

    private val permissionList = arrayOf(
        Manifest.permission.ACCESS_COARSE_LOCATION,
        Manifest.permission.ACCESS_FINE_LOCATION
    )

    private val requestPermissions = registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()) {
        for (entry in it) {
            LogUtil.d("permission: $entry")
            if (!entry.value) {
                Toast.makeText(this, "권한을 허용해주세요.", Toast.LENGTH_SHORT).show()
                finish()
            }
            startMainActivity()
        }
    }

    private fun checkPermissions(permissions: Array<String>): Boolean {
        val grantedPermissions = permissions.filter {
            ContextCompat.checkSelfPermission(this, it) == PackageManager.PERMISSION_GRANTED
        }
        return grantedPermissions.size == permissions.size
    }

    private fun startMainActivity() {
        startActivity(Intent(this, MainActivity::class.java).apply {
            this.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        })
    }

    companion object {
        private const val PERMISSION_REQUEST_CODE = 1
    }
}