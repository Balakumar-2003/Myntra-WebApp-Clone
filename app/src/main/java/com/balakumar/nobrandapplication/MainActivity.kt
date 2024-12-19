package com.balakumar.nobrandapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.balakumar.nobrandapplication.data.Repository
import com.balakumar.nobrandapplication.ui.theme.NoBrandApplicationTheme

class MainActivity : ComponentActivity() {

    lateinit var navcontroller: NavHostController
    private  val repository = Repository()
    private val viewModelProvider= HomeScreenViewModelProvider(repository = repository)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val viewmodel =ViewModelProvider(this,viewModelProvider).get(HomeScreenViewModel::class.java)
            navcontroller= rememberNavController()
            NoBrandApplicationTheme {
                Home(navcontroller,viewmodel)
            }
        }
    }
}
