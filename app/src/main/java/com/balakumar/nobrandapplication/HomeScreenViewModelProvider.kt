package com.balakumar.nobrandapplication

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.balakumar.nobrandapplication.data.Repository

@Suppress("UNCHECKED_CAST")
class HomeScreenViewModelProvider(val repository: Repository): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeScreenViewModel::class.java)){
            return HomeScreenViewModel(repository = repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
