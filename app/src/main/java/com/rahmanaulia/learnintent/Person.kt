package com.rahmanaulia.learnintent

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Person(
    val name: String? = null,
    val age: Int? = null,
    val email: String? = null,
    val city: String? = null
): Parcelable