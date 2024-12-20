package com.balakumar.nobrandapplication

import android.app.Application
import com.balakumar.nobrandapplication.data.Repository

class MyApplication:Application() {
    private lateinit var repository: Repository
    override fun onCreate() {
        super.onCreate()
        repository=Repository()
    }
    fun getRepository():Repository{
        return repository
    }
}