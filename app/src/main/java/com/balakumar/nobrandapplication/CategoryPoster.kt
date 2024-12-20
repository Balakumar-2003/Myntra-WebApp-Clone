package com.balakumar.nobrandapplication

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.balakumar.nobrandapplication.data.CategoryPoster
import com.balakumar.nobrandapplication.ui.theme.NoBrandApplicationTheme


@Composable
fun CategoryPoster(
    index:Int,
    Category:CategoryPoster,
    viewModel: HomeScreenViewModel,
    navController: NavController
){

    Surface(modifier= Modifier
        .height(100.dp)
        .width(80.dp)
        .padding(4.dp)
        .clickable(onClick = {navController.navigate("CategoryScreen/$index")})
    ){
        Box(modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFFFFDA16)),
            contentAlignment = Alignment.Center
        ){
            Column(modifier = Modifier
                .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ){
                Image(painter = painterResource( Category.image),
                    contentDescription = "women",
                    modifier = Modifier
                        .padding(top = 4.dp)
                        .size(width = 60.dp, height = 65.dp)
                        .clip(viewModel.hexagonShape()),
                    contentScale = ContentScale.Crop)
                Text(text = stringResource(Category.category),
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp,
                    modifier = Modifier.padding(2.dp))
                }
        }
    }
}




@Preview(showBackground = true)
@Composable
fun PreviewCategoryPoster(){
    NoBrandApplicationTheme {
        Surface (modifier = Modifier.fillMaxSize()){
            CategoryPoster(index = 0, Category = CategoryPoster(R.drawable.women, R.string.women), viewModel = viewModel<HomeScreenViewModel>(),
                rememberNavController()
            )
        }
    }
}