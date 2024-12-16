package com.balakumar.nobrandapplication

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.balakumar.nobrandapplication.ui.theme.NoBrandApplicationTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(navcontroller: NavHostController, modifier:Modifier=Modifier){
    var searchItem by remember{ mutableStateOf("") }
    Scaffold (modifier = modifier.fillMaxWidth(),
        topBar = {
            TopAppBar(
                modifier= modifier.shadow(2.dp).padding(2.dp),
               navigationIcon = {
                   IconButton(onClick = {navcontroller.navigate(NavigationRoute.HomeScreen.route)}) {
                       Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "return")
                   }
               },
                title = {
                    BasicTextField(value = searchItem,
                        onValueChange = {searchItem=it},
                        modifier = modifier.height(56.dp).fillMaxSize(),

                        )
                },
                actions = {}
            )
        }){ innerPadding->
        Column(modifier = Modifier.fillMaxSize().padding(innerPadding)) {

        }

    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSearchScreen(){
    NoBrandApplicationTheme {
        SearchScreen(rememberNavController())
    }
}