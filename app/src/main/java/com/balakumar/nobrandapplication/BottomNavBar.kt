package com.balakumar.nobrandapplication


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun BottomNavBar(viewModel: HomeScreenViewModel){
    val list =viewModel.getBottomNavList()
    val listSelected = viewModel.getBottomNavSelectedList()
    var selectedIndex by remember {
        mutableStateOf(0)
    }

    Row(modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.Top){
    list.forEachIndexed { Index, bottomNav ->
      val image by remember {
          derivedStateOf {
              if (selectedIndex == Index) {
                  listSelected[Index].image

              } else {
                  bottomNav.image
              }
          }
      }
      val color by remember {
          derivedStateOf {
              if (selectedIndex == Index) {
                  Color.Red

              } else {
                  Color.Black
              }
          }
      }
      val colorfun:(Color) -> Color={ color -> if(color==Color.Black){Color.Transparent}
      else{Color.Red}}
          Box(
              modifier = Modifier
                  .fillMaxSize()
                  .weight(1f)
                  .clickable(onClick = {
                      selectedIndex = Index
                  })
                  .background(Color(0xFFFFFFFF)), contentAlignment = Alignment.Center
          ) {
              Column(
                  horizontalAlignment = Alignment.CenterHorizontally,
                  verticalArrangement = Arrangement.Top
              ) {
                  Box (modifier = Modifier
                      .height(4.dp)
                      .fillMaxWidth()
                      .background(color=colorfun(color)))
                  Image(
                      painter =
                      painterResource(image),
                      contentDescription = "myntra",
                      modifier = Modifier
                          .size(height = 36.dp, width = 36.dp)
                          .weight(1.0f)
                  )
                  Text(
                      text = stringResource(id = bottomNav.string),
                      modifier = Modifier.padding(bottom = 2.dp),
                      fontSize = 12.sp,
                      fontWeight = FontWeight.Light,
                      color = color
                  )
              }
          }
   }
  }
}