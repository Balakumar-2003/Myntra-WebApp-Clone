package com.balakumar.nobrandapplication.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class CategoryPoster(
    @DrawableRes val image:Int,
    @StringRes val category: Int
)