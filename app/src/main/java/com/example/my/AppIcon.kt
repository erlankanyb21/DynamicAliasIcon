package com.example.my

import androidx.annotation.DrawableRes

data class AppIcon(
    val id: String,
    val component: String,
    @DrawableRes
    val foregroundResource: Int
)

val appIcons: List<AppIcon> = listOf(
    AppIcon(
        id = "default",
        component = "com.example.my.MainActivity",
        foregroundResource = R.drawable.ic_launcher_foreground
    ),
    AppIcon(
        id = "smile",
        component = "com.example.my.MainActivitySmile",
        foregroundResource = R.drawable.ic_launcher_smile_playstore
    ),
    AppIcon(
        id = "tongue",
        component = "com.example.my.MainActivityTongue",
        foregroundResource = R.drawable.ic_launcher_tongue_playstore
    ),
    AppIcon(
        id = "sad",
        component = "com.example.my.MainActivitySad",
        foregroundResource = R.drawable.ic_launcher_sad_playstore
    )
)