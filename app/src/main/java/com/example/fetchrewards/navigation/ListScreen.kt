package com.example.fetchrewards.navigation

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.fetchrewards.R
import com.example.fetchrewards.data.model.ItemModel
import com.example.fetchrewards.viewModel.FetchViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListScreen(
    navController: NavHostController
) {

    val itemViewModel: FetchViewModel = hiltViewModel()
    val state = itemViewModel.state

    Scaffold(
        modifier = Modifier.background(Color.Transparent),
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Discover Fetch Rewards",
                        fontFamily = FontFamily(Font(R.font.alexandria_medium)),
                        fontWeight = FontWeight.Bold,
                        fontSize = 24.sp

                    )
                },
            )
        },
        content = { paddingValues ->
            LazyColumn (contentPadding = paddingValues){
                items(state.items.size){
                   ItemCard(itemIndex = it, itemList = state.items, navController =navController)
                }
            }
        },
        contentColor = Color.Transparent
    )
}

@Composable
fun ItemCard(itemIndex: Int, itemList: List<ItemModel>, navController: NavHostController) {

    Card(
        Modifier
            .padding(10.dp)
            .clickable {
                navController.navigate("Detail Screen/${itemList[itemIndex].id}")
            },
        elevation = CardDefaults.cardElevation(8.dp),
    ){
        Row(modifier = Modifier.padding(10.dp), Arrangement.SpaceEvenly) {
            Image(
                painter = painterResource(id = R.drawable.logo_item_purple),
                contentDescription = "productImage",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))
                    .size(100.dp)
                    .padding(2.dp)

            )
            Column (modifier = Modifier.fillMaxWidth()) {
                Text(text = itemList[itemIndex].name,
                    modifier = Modifier
                        .padding(start = 16.dp, top = 8.dp)
                        .basicMarquee(),
                    textAlign = TextAlign.Start,
                    fontWeight = FontWeight.SemiBold,
                    maxLines = 1,
                    fontFamily = FontFamily(Font(R.font.alexandria_medium)),
                    fontSize = 18.sp

                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = itemList[itemIndex].listId.toString(),
                    modifier = Modifier.padding(start = 16.dp)
                        .clip(RoundedCornerShape(8.dp)),

                    textAlign = TextAlign.Start,
                    fontWeight = FontWeight.SemiBold,
                    maxLines = 1,
                    fontFamily = FontFamily(Font(R.font.alexandria_medium)),
                    fontSize = 14.sp

                )

            }

        }

    }

}

