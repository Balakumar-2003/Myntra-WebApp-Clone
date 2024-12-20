package com.balakumar.nobrandapplication

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.balakumar.nobrandapplication.ui.theme.NoBrandApplicationTheme
import kotlinx.coroutines.delay
import kotlin.math.absoluteValue


@SuppressLint("SuspiciousIndentation", "CoroutineCreationDuringComposition")
@Composable
fun HomeScreen(navcontroller: NavHostController, modifier: Modifier=Modifier, innerPadding:PaddingValues,viewModel: HomeScreenViewModel){
        var searchText by remember{
            mutableStateOf("")
        }

    val banner = viewModel.getBannerList()
    val pageState =rememberPagerState(pageCount = {banner.size})
    val text = stringResource(R.string.search)
        LaunchedEffect(key1 = true){
            while (true){
                if(searchText=="") {
                    delay(500)
                    for (i in 0..text.length - 1) {
                        delay(100)
                        searchText = searchText + text[i]
                    }
                    delay(1000)
                }
                else{
                    searchText=""

                }

            }

        }
        Column (modifier = modifier
            .fillMaxSize()
            .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top){
            Surface (modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = 16.dp,
                    bottom = 16.dp,
                    start = 8.dp,
                    end = 8.dp
                )
                .height(40.dp)
                .clickable(onClick = { navcontroller.navigate(NavigationRoute.SearchScreen.route) }),
                shape = RoundedCornerShape(100),
                shadowElevation = 8.dp){

                Box(modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.CenterStart){
                    Row (modifier = Modifier.fillMaxWidth()){

                        Spacer(modifier = Modifier.padding(4.dp))

                        Icon(painter = painterResource(R.drawable.sharp_search_24),
                            modifier = Modifier
                                .size(30.dp)
                                .padding(top = 8.dp),
                            contentDescription = "search",
                            tint = Color.Gray)

                        Text(text = searchText,
                            modifier = Modifier.padding(top = 8.dp,
                                bottom = 8.dp,
                                end = 8.dp),
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Normal,
                            color = Color.Gray)

                    }
                }
            }
            LazyRow (modifier = Modifier.padding(start = 8.dp , top = 4.dp, end = 4.dp, bottom = 4.dp)){
                itemsIndexed(viewModel.getCategoryList()){index,items->
                    CategoryPoster(index,items, viewModel = viewModel,navcontroller)
                }
            }
            Spacer(modifier = Modifier.height(2.dp))
            HorizontalPager(state = pageState ) {page->
                Card(
                    Modifier
                        .fillMaxWidth()
                        .height(270.dp)
                        .graphicsLayer {
                            // Calculate the absolute offset for the current page from the
                            // scroll position. We use the absolute value which allows us to mirror
                            // any effects for both directions
                            val pageOffset = (
                                    (pageState.currentPage - page) + pageState
                                        .currentPageOffsetFraction
                                    ).absoluteValue

                            // We animate the alpha, between 50% and 100%
                            alpha = lerp(
                                start = 0.5f,
                                stop = 1f,
                                fraction = 1f - pageOffset.coerceIn(0f, 1f)
                            )
                        }
                ) {
                    Image(painter = painterResource(id=banner[page].image),
                        contentDescription = "Image $page",
                        modifier = Modifier
                            .fillMaxSize()
                            .clickable(onClick = {}),
                        contentScale = ContentScale.FillBounds)
                    // Card content
                }

            }
            Spacer(modifier = Modifier.height(2.dp))
            Row (modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .padding(top = 4.dp, bottom = 4.dp),
                horizontalArrangement = Arrangement.Center){
                repeat(times = pageState.pageCount){iteration->
                    var color = if(iteration==pageState.currentPage) Color.DarkGray else Color.LightGray
                    Box(modifier = Modifier
                        .padding(2.dp)
                        .clip(CircleShape)
                        .background(color)
                        .size(6.dp))
                }
            }

            LaunchedEffect(pageState) {
                while (true) {
                    delay(3000)
                    val nextPage = (pageState.currentPage + 1) % banner.size
                    pageState.animateScrollToPage(nextPage)
                }
            }
        }
}

@Preview(showBackground = true)
@Composable
fun PreviewHomeScreen(){
    NoBrandApplicationTheme {
        HomeScreen(rememberNavController(), innerPadding = PaddingValues(1.dp),viewModel = viewModel<HomeScreenViewModel>())

    }

}