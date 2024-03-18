package com.ifs21018.dinopedia

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
@Parcelize
data class Dino(
    var name: String,
    var icon: Int,
    var description: String,
    var characteristic: String,
    var group: String,
    var habitat: String,
    var food: String,
    var length: String,
    var height: String,
    var weight: String,
    var weakness: String,
) : Parcelable