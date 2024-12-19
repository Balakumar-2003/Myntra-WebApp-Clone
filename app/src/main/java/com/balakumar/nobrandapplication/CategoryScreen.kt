package com.balakumar.nobrandapplication


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun CategoryScreen(navController: NavController,innerPadding:PaddingValues){
    Surface (modifier = Modifier.fillMaxSize().padding(innerPadding)){
        Column (modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center){
            IconButton(onClick = {navController.popBackStack()}){
                Icon(imageVector = Icons.Default.ArrowBack,
                    contentDescription = "backButton")
            }
        }
    }
}