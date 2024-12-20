package com.balakumar.nobrandapplication.data

interface repository {
    fun getCategoryItems(id:Int):List<CategoryItems>
    fun getItems(index:Int,id:Int):CategoryItems
}
