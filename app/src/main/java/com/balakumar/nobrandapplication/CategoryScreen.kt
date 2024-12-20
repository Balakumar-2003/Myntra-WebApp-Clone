package com.balakumar.nobrandapplication


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@Composable
fun CategoryScreen(navController: NavController,innerPadding:PaddingValues){
    val context = LocalContext.current
    val myApplication = context.applicationContext as MyApplication
    val index = navController.currentBackStackEntry?.arguments?.getString("index")?:"0"
    val Index =index.toInt()
    val itemList = myApplication.getRepository().getCategoryItems(Index)
    Column (modifier = Modifier
        .fillMaxSize()
        .padding(innerPadding)){
        Box(modifier= Modifier
            .height(56.dp)
            .fillMaxWidth()
            .background(Color.Magenta),
            contentAlignment = Alignment.Center){
            Column (horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center){
                Text("FLAT 300 OFF",
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp,
                    color = Color.White,
                    modifier = Modifier.padding(4.dp))
                Text("MYNTRA300",
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp,
                    color = Color.White,
                    modifier = Modifier.padding(4.dp))
            }

        }
        LazyVerticalGrid(columns = GridCells.Fixed(2), modifier = Modifier.fillMaxWidth()) {
            items(itemList) { item ->
                val percentage = (100-((item.price/100)*item.currentPrice))
                val priceWithCoupon =item.currentPrice-item.coupenDiscount
                Surface(modifier = Modifier
                    .fillMaxSize(),
                    onClick = {navController.navigate("ItemScreen/$Index/${item.id}")  }
                ) {
                    Column {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(270.dp)
                                .padding(top = 1.dp, bottom = 2.dp),
                            contentAlignment = Alignment.BottomStart
                        ) {
                            Image(
                                painter = painterResource(id = item.image),
                                contentDescription = item.type,
                                modifier = Modifier.fillMaxSize(),
                                contentScale = ContentScale.Crop
                            )
                        }
                        Row (modifier = Modifier
                            .wrapContentHeight()
                            .fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween){
                            Column (modifier = Modifier
                                .wrapContentHeight()
                                .weight(0.8f)
                                .fillMaxWidth(),
                                horizontalAlignment = Alignment.Start,
                                verticalArrangement = Arrangement.SpaceBetween){
                                Text(text = stringResource(id = item.name),
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Bold,
                                    style = TextStyle(fontStyle = MaterialTheme.typography.h1.fontStyle),
                                    modifier = Modifier
                                        .padding(start = 6.dp, bottom = 2.dp, top = 2.dp, end = 2.dp)
                                )
                                Text(text = item.type,
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Normal,
                                    color = Color.Gray,
                                    style = TextStyle(fontStyle = MaterialTheme.typography.h1.fontStyle),
                                    modifier = Modifier
                                        .padding(start = 6.dp, bottom = 2.dp, end = 2.dp)
                                )
                            }

                            IconButton(onClick = {}, modifier = Modifier.weight(0.2f)){
                                Icon(painter = painterResource(R.drawable.heart),
                                    modifier = Modifier
                                        .size(height = 24.dp, width = 24.dp),
                                    contentDescription = "heart")
                            }
                        }

                        Row (modifier = Modifier
                            .wrapContentHeight()
                            .fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically){
                            Text(text = "₹"+item.currentPrice ,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold,
                                style = TextStyle(fontStyle = MaterialTheme.typography.h1.fontStyle),
                                modifier = Modifier
                                    .padding(start = 6.dp, bottom = 2.dp, end = 4.dp)
                            )
                            Text(text = "₹"+item.price,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Normal,
                                color = Color.Gray,
                                style = TextStyle(fontStyle = MaterialTheme.typography.h1.fontStyle,
                                    textDecoration = TextDecoration.LineThrough),
                                modifier = Modifier
                                    .padding(bottom = 2.dp, end = 4.dp)
                            )
                            Text(text = "($percentage% OFF)",
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Normal,
                                color = Color(0xFFFF9800),
                                style = TextStyle(fontStyle = MaterialTheme.typography.h1.fontStyle),
                                modifier = Modifier
                                    .padding(bottom = 2.dp, end = 4.dp)
                            )
                        }
                        Row (modifier = Modifier
                            .wrapContentHeight()
                            .fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                text = "Best Price ₹$priceWithCoupon",
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Normal,
                                color = Color(0xFF8BC34A),
                                style = TextStyle(fontStyle = MaterialTheme.typography.h1.fontStyle),
                                modifier = Modifier
                                    .padding(start = 6.dp, bottom = 2.dp, end = 2.dp)
                            )
                            Text(
                                text = "with coupon",
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Normal,
                                color = Color.Gray,
                                style = TextStyle(fontStyle = MaterialTheme.typography.h1.fontStyle),
                                modifier = Modifier
                                    .padding(bottom = 2.dp, end = 2.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}