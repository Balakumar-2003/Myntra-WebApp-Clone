package com.balakumar.nobrandapplication

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun ItemScreen(navController: NavController){
    val context = LocalContext.current
    val myApplication = context.applicationContext as MyApplication
    val index = navController.currentBackStackEntry?.arguments?.getString("index")?:"0"
    val Index =index.toInt()
    val id = navController.currentBackStackEntry?.arguments?.getString("id")?:"0"
    val Id =id.toInt()
    val item= myApplication.getRepository().getItems(index=Index, id = Id)
    Column (modifier = Modifier
        .fillMaxSize()
        .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top){
        Box(modifier = Modifier
            .height(56.dp)
            .fillMaxWidth().weight(0.2f)){

        }
        Surface (modifier = Modifier
            .height(500.dp)
            .fillMaxWidth().weight(0.8f),
            shape = RoundedCornerShape(bottomStartPercent = 25,
                bottomEndPercent = 25)){
            Image(painter = painterResource(id = item.image),
                contentDescription =item.type,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.FillBounds)

        }
    }
}