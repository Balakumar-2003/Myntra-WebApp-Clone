package com.balakumar.nobrandapplication

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.balakumar.nobrandapplication.ui.theme.NoBrandApplicationTheme



@Composable
fun HomeScreen(navcontroller: NavHostController, modifier: Modifier=Modifier, innerPadding:PaddingValues){
        Column (modifier = modifier.fillMaxSize().padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top){
            Surface (modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp,
                    bottom = 16.dp,
                    start = 8.dp,
                    end = 8.dp).height(40.dp).clickable (onClick = {navcontroller.navigate(NavigationRoute.SearchScreen.route)}),
                shape = RoundedCornerShape(100),
                shadowElevation = 2.dp){
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.CenterStart){
                    Row (modifier = Modifier.fillMaxWidth()){
                        Spacer(modifier = Modifier.padding(4.dp))
                        Icon(painter = painterResource(R.drawable.sharp_search_24),
                            modifier = Modifier.size(30.dp).padding(top = 8.dp),
                            contentDescription = "search",
                            tint = Color.Gray)
                        Text(text = stringResource(R.string.search),
                            modifier = Modifier.padding(top = 8.dp,
                                bottom = 8.dp,
                                end = 8.dp),
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Normal,
                            color = Color.Gray)

                    }



                }


            }
        }
}

@Preview(showBackground = true)
@Composable
fun PreviewHomeScreen(){
    NoBrandApplicationTheme {
        HomeScreen(rememberNavController(), innerPadding = PaddingValues(1.dp))

    }

}