package com.balakumar.nobrandapplication

import androidx.compose.foundation.shape.GenericShape
import androidx.lifecycle.ViewModel
import com.balakumar.nobrandapplication.data.CategoryPoster
import com.balakumar.nobrandapplication.data.Repository

class HomeScreenViewModel(repository: Repository) :ViewModel(){
    private val categoryList =repository.getCategoryList()

    fun getCategoryList():List<CategoryPoster>{
        return categoryList
    }
    fun hexagonShape() = GenericShape { size, _ ->
        val width = size.width
        val height = size.height
        val midX = width / 2

        moveTo(midX, 0f)
        lineTo(width, height * 0.25f)
        lineTo(width, height * 0.75f)
        lineTo(midX, height)
        lineTo(0f, height * 0.75f)
        lineTo(0f, height * 0.25f)
        close()
    }
}