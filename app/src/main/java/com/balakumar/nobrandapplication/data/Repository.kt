package com.balakumar.nobrandapplication.data


import com.balakumar.nobrandapplication.R

class Repository {
    private val categoryList = mutableListOf(
        CategoryPoster(
            image = R.drawable.men,
            category = R.string.men),
        CategoryPoster(
            image = R.drawable.women,
            category = R.string.women),
        CategoryPoster(
            image = R.drawable.kids,
            category = R.string.kids),
        CategoryPoster(
            image = R.drawable.footwear,
            category = R.string.footwear)
        ,CategoryPoster(
            image = R.drawable.accessories,
            category = R.string.accessories),
        CategoryPoster(
            image = R.drawable.fitness,
            category = R.string.fitness),
        CategoryPoster(
            image = R.drawable.watch,
            category = R.string.watch),
        CategoryPoster(
            image = R.drawable.luggage,
            category = R.string.luggage),
        CategoryPoster(
            image = R.drawable.jewellary,
            category = R.string.jewellery),
        CategoryPoster(
            image = R.drawable.gadgets,
            category = R.string.gadgets),
        CategoryPoster(
            image = R.drawable.beauty,
            category = R.string.beauty),
    )

    fun getCategoryList():List<CategoryPoster>{
        return categoryList
    }
}