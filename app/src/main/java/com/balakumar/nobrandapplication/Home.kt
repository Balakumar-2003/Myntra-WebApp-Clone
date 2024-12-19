package com.balakumar.nobrandapplication

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(navcontroller: NavHostController,viewModel: HomeScreenViewModel){
    Scaffold (
        modifier = Modifier.fillMaxWidth(),

        topBar = {
            TopAppBar(
                modifier = Modifier.shadow(2.dp).padding(2.dp),
                navigationIcon = {
                    IconButton(onClick = {}){
                        Icon(painter = painterResource(R.drawable.baseline_density_medium_24),
                        contentDescription = "medium_density")
                    }
                                 },
                title ={ Image(painter = painterResource(R.drawable.myntra2),
                    modifier = Modifier.size(56.dp),
                    contentDescription = "Myntra_Logo") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background),
                actions = {
                    IconButton(onClick = {}){
                        Icon(painter = painterResource(R.drawable.baseline_add_comment_24),
                            modifier = Modifier.size(24.dp),
                            contentDescription = "add")
                    }
                    IconButton(onClick = {}){
                    Icon(painter = painterResource(R.drawable.heart),
                        modifier = Modifier.size(24.dp),
                        contentDescription = "heart")
                    }
                    IconButton(onClick = {}){
                        Icon(painter = painterResource(R.drawable.bag),
                            modifier = Modifier.size(24.dp),
                            contentDescription = "bag")
                    }
                }
            )
        },

        bottomBar = {

           }
    ){ innerPadding->
        HomeScreen(navcontroller,innerPadding = innerPadding, viewModel = viewModel)

    }
}