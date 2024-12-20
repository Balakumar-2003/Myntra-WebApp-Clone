package com.balakumar.nobrandapplication.data


import com.balakumar.nobrandapplication.R

class Repository :repository{
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

    private val MensCategory = mutableListOf(
        CategoryItems(id = 0, image = R.drawable.shirt1, name = R.string.shirt1, type = "casual Shirt", currentPrice = 750, price = 2000, coupenDiscount = 200),
        CategoryItems(id = 1,image = R.drawable.shirt2, name = R.string.shirt2, type = "formal blue Shirt", currentPrice = 450, price = 1350, coupenDiscount = 200),
        CategoryItems(id = 2,image = R.drawable.shirt3, name = R.string.shirt3, type = "checked Shirt", currentPrice = 500, price = 2500, coupenDiscount = 200),
        CategoryItems(id = 3,image = R.drawable.shirt4, name = R.string.shirt4, type = "formal green Shirt", currentPrice = 550, price = 1750, coupenDiscount = 200),
        CategoryItems(id = 4,image = R.drawable.pant1, name = R.string.pant1, type = "black fit trowser", currentPrice = 1000, price =2350, coupenDiscount = 200),
        CategoryItems(id = 5,image = R.drawable.pant2, name = R.string.pant2, type = "white fit trowser", currentPrice = 700, price = 1750, coupenDiscount = 200),
        CategoryItems(id = 6,image = R.drawable.pant3, name = R.string.pant3, type = "mens fit trowser", currentPrice = 500, price = 1450, coupenDiscount = 200),
        CategoryItems(id = 7,image = R.drawable.pant4, name = R.string.pant4, type = "mens fit trowser", currentPrice = 750, price = 2050, coupenDiscount = 200),
        CategoryItems(id = 8,image = R.drawable.pant5, name = R.string.pant5, type = "mens fit trowser", currentPrice = 1100, price = 2750, coupenDiscount = 200),
        CategoryItems(id = 9,image = R.drawable.pant6, name = R.string.pant6, type = "mens fit trowser", currentPrice = 1900, price = 3050, coupenDiscount = 200),
        CategoryItems(id = 10,image = R.drawable.pant7, name = R.string.pant7, type = "mens fit trowser", currentPrice = 600, price = 1550, coupenDiscount = 200),
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

    override fun getCategoryItems(id: Int): List<CategoryItems> {

        if(id==0){return MensCategory}
        else{
            return emptyList()
        }
    }

    override fun getItems(index:Int,id: Int): CategoryItems {
        if (index == 0){
            return MensCategory[id]
        }
        else return CategoryItems(id=-1, image = R.drawable.shirt1, name = R.string.shirt1, type = "casual Shirt", currentPrice = 750, price = 2000, coupenDiscount = 200)
    }


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