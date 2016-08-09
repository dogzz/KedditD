@file:JvmName("ExtensionsUtils")

package com.dogzz.kedditd.commons

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by afon on 09.08.2016.
 */

fun ViewGroup.inflate(layoutId: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutId, this, attachToRoot)
}
