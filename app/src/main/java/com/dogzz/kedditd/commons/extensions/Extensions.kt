@file:JvmName("ExtensionsUtils")

package com.dogzz.kedditd.commons.extensions

import android.os.Parcel
import android.os.Parcelable
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.dogzz.kedditd.R
import com.squareup.picasso.Picasso

/**
 * Extensions for Android UI Components
 * Created by afon on 09.08.2016.
 */

fun ViewGroup.inflate(layoutId: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutId, this, attachToRoot)
}

fun ImageView.loadImg(imageUrl: String) {
    if (TextUtils.isEmpty(imageUrl)) {
        Picasso.with(context).load(R.mipmap.ic_launcher).into(this)
    } else {
        Picasso.with(context).load(imageUrl).placeholder(R.mipmap.ic_launcher).into(this)
    }
}

/**
 * Inline function to create Parcel Creator
 */
inline fun <reified T : Parcelable> createParcel(
        crossinline createFromParcel: (Parcel) -> T?): Parcelable.Creator<T> =
        object : Parcelable.Creator<T> {
            override fun createFromParcel(source: Parcel): T? = createFromParcel(source)
            override fun newArray(size: Int): Array<out T?> = arrayOfNulls(size)
        }