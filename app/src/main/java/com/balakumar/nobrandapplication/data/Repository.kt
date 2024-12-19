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
    private val BottomNavSlectedList = mutableListOf(
        BottomNav(
            image = R.drawable.myntrabuttonclicked,
            string = R.string.Nav_Home),
        BottomNav(
            image = R.drawable.fwdbuttonclicked,
            string = R.string.Nav_fwd),
        BottomNav(
            image = R.drawable.beautybuttonclicked,
            string = R.string.Nav_beauty),
        BottomNav(
            image = R.drawable.profilebutton,
            string = R.string.Nav_profile),
    )
    private val BottomNavList = mutableListOf(
        BottomNav(
            image = R.drawable.myntrabutton,
            string = R.string.Nav_Home),

        BottomNav(
            image = R.drawable.fwdbutton,
            string = R.string.Nav_fwd),

        BottomNav(
            image = R.drawable.beautybutton,
            string = R.string.Nav_beauty),

        BottomNav(
            image = R.drawable.profilebutton,
            string = R.string.Nav_profile),
    )
    private val BannerList = mutableListOf(
        Banner(R.drawable.banner1),
        Banner(R.drawable.banner2),
        Banner(R.drawable.banner3i),
        Banner(R.drawable.banner4),
        Banner(R.drawable.banner5),
        Banner(R.drawable.banner6),
        Banner(R.drawable.banner7),
        Banner(R.drawable.banner8),
        Banner(R.drawable.banner9),
        Banner(R.drawable.banner10)
    )

    fun getBottomNavList():List<BottomNav>{
        return BottomNavList
    }
    fun getBottomNavSelectedList():List<BottomNav>{
        return BottomNavSlectedList
    }

    fun getBannerList():List<Banner>{
        return BannerList
    }

    fun getCategoryList():List<CategoryPoster>{
        return categoryList
    }
}