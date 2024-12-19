package com.balakumar.nobrandapplication

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.balakumar.nobrandapplication.ui.theme.NoBrandApplicationTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(navcontroller: NavHostController,innerPadding:PaddingValues, modifier:Modifier=Modifier){
    var searchItem by remember{ mutableStateOf("") }
    Column (modifier = modifier.padding(innerPadding).fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top){
        Row (modifier = Modifier.fillMaxWidth().height(56.dp).drawBehind {
            drawRect(
                color = Color.Gray,
                topLeft = Offset(0f, size.height),
                size = Size(size.width, 1.dp.toPx())
            )
        },
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically){
                IconButton(onClick = {navcontroller.popBackStack()}, modifier = Modifier.size(height = 48.dp, width = 48.dp)) {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "return")
                }
            Box(modifier = Modifier.fillMaxSize()){
                BasicTextField(value = searchItem,
                    onValueChange = {searchItem=it},
                    modifier = Modifier.fillMaxSize()
                        .padding(8.dp),
                    textStyle = TextStyle(fontSize = 24.sp, color = Color.Black, textAlign = TextAlign.Start),
                    singleLine = true, cursorBrush = SolidColor(Color.Red),
                    decorationBox = { innerTextField ->
                        Box(
                            modifier = Modifier
                                .padding(8.dp)
                                .fillMaxWidth(),
                            contentAlignment = Alignment.CenterStart
                        ) {
                            innerTextField()
                        }
                    }
                )
            }

        }
    }


}

@Preview(showBackground = true)
@Composable
fun PreviewSearchScreen(){
    NoBrandApplicationTheme {
        SearchScreen(rememberNavController(),PaddingValues(1.dp))
    }
}