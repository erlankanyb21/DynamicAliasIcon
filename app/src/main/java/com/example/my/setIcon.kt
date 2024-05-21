package com.example.my

import android.app.Activity
import android.content.ComponentName
import android.content.Context
import android.content.pm.PackageManager

fun Activity.setIcon(enable: String, disable: String) {
    packageManager.setComponentEnabledSetting(
        ComponentName(this, "$packageName.$enable"),
        PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
        PackageManager.DONT_KILL_APP
    )
    packageManager.setComponentEnabledSetting(
        ComponentName(this, "$packageName.$disable"),
        PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
        PackageManager.DONT_KILL_APP
    )
}

fun setAppIcon(iconId: String, context: Context) {
    val icon = appIcons.find { it.id == iconId } ?: return
    val packageManager = context.packageManager

    appIcons.filterNot { it.id == iconId }.forEach {
        packageManager.setComponentEnabledSetting(
            ComponentName(context, it.component),
            PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
            PackageManager.DONT_KILL_APP
        )
    }

    packageManager.setComponentEnabledSetting(
        ComponentName(context, icon.component),
        PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
        PackageManager.DONT_KILL_APP
    )
}