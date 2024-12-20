package com.balakumar.nobrandapplication.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class CategoryItems(
    val id : Int,
    @DrawableRes val image:Int,
    @StringRes val name:Int,
    val type:String,
    val currentPrice : Int,
    val price : Int,
    val coupenDiscount : Int
)
