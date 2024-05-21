package com.example.my

import android.annotation.SuppressLint
import android.app.Activity
import android.content.ComponentName
import android.content.pm.PackageManager
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import com.example.my.ui.theme.MyTheme
import java.util.Calendar

class MainActivity : ComponentActivity() {

    private val handler = Handler(Looper.getMainLooper())
    private val iconCheckInterval: Long = 60 * 1000 // 1 minute in milliseconds

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        Toast.makeText(this, "ICON", Toast.LENGTH_SHORT).show()
        setContent {
            MyTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    Column {
                        Button(onClick = {
                            setAppIcon("default", this@MainActivity)
                        }) {
                            Text(text = "default")
                        }

                        Button(onClick = {
                            setAppIcon("smile", this@MainActivity)
//                            setIcon(enable = "MainActivityAlias", disable = "MainActivity")
                        }) {
                            Text(text = "smile")
                        }

                        Button(onClick = {
                            setAppIcon("sad", this@MainActivity)
                        }) {
                            Text(text = "sad")
                        }

                        Button(onClick = {
                            setAppIcon("tongue", this@MainActivity)
                        }) {
                            Text(text = "tongue")
                        }
                    }
                }
            }
        }
        checkAndUpdateIcon()
    }

    private fun checkAndUpdateIcon() {
        val calendar = Calendar.getInstance()
        val month = calendar.get(Calendar.MONTH)

        val iconName = when (month) {
            Calendar.DECEMBER, Calendar.JANUARY, Calendar.FEBRUARY -> "tongue" // Winter
            Calendar.MARCH, Calendar.APRIL, Calendar.MAY -> "smile" // Spring
            Calendar.JUNE, Calendar.JULY, Calendar.AUGUST -> "default" // Summer
            Calendar.SEPTEMBER, Calendar.OCTOBER, Calendar.NOVEMBER -> "sad" // Autumn
            else -> "default" // Default to "default" icon for any other cases
        }

        setAppIcon(iconName, this@MainActivity)
    }

//    private fun startIconCheck() {
//        handler.post(object : Runnable {
//            override fun run() {
//                checkAndUpdateIcon()
//                handler.postDelayed(this, iconCheckInterval)
//            }
//        })
//    }
//
//    private fun checkAndUpdate() {
//        val calendar = Calendar.getInstance()
//        val hour = calendar.get(Calendar.HOUR_OF_DAY)
//        val minute = calendar.get(Calendar.MINUTE)
//
//        if (minute % 2 == 0) {
//            setIcon(enable = "MainActivityAlias", disable = "MainActivity")
//        } else {
//            setIcon(enable = "MainActivity", disable = "MainActivityAlias")
//        }
//    }
}