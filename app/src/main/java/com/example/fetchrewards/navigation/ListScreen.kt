package com.example.fetchrewards.navigation

import android.content.res.Resources.Theme
import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
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
import com.example.fetchrewards.ui.theme.AquaBlue
import com.example.fetchrewards.ui.theme.FetchColor
import com.example.fetchrewards.ui.theme.PurpleGrey40
import com.example.fetchrewards.ui.theme.PurpleGrey80
import com.example.fetchrewards.viewModel.FetchViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListScreen(
    navController: NavHostController,
    itemViewModel: FetchViewModel = hiltViewModel()
) {
    val state = itemViewModel.state
    var selectedChip by rememberSaveable { mutableIntStateOf(0) } // small bug fixed here!

    val filteredItems = if (selectedChip == 0) {
        state.value.items
    } else {
        state.value.items.filter { it.listId == selectedChip }
    }

    Scaffold(
        modifier = Modifier.background(Color.Transparent),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Discover Fetch Rewards",
                        fontFamily = FontFamily(Font(R.font.alexandria_medium)),
                        fontWeight = FontWeight.Bold,
                        fontSize = 24.sp
                    )
                },
            )
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .padding(paddingValues)
            ) {

                LazyRow(
                    modifier = Modifier.padding(8.dp)
                ) {
                    items(state.value.count + 1) { i ->
                        AssistChip(
                            modifier = Modifier
                                .padding(end = 8.dp),
                            onClick = {
                                selectedChip = i
                            },
                            label = {
                                if (i == 0) Text(
                                    "All Categories",
                                    fontFamily = FontFamily(Font(R.font.alexandria_medium))
                                ) else Text(
                                    "Items $i",
                                    fontFamily = FontFamily(Font(R.font.alexandria_medium))
                                )
                            },
                            colors = AssistChipDefaults.assistChipColors(
                                containerColor = if (i == selectedChip) {
                                    if (isSystemInDarkTheme()) PurpleGrey40 else PurpleGrey80

                                } else Color.Transparent, // Cambiar color directamente
                                )

                        )
                    }
                }

                AnimatedContent(targetState = filteredItems.isEmpty(), label = "") { isEmpty ->
                    if (isEmpty) {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            CircularProgressIndicator()
                        }

                    } else {
                        LazyColumn {
                            items(filteredItems.size) { index ->
                                ItemCard(
                                    itemIndex = index,
                                    itemList = filteredItems,
                                    navController = navController,
                                    onDelete = { item ->
                                        itemViewModel.deleteById(item)
                                    }
                                )
                            }
                        }
                    }
                }
            }
        }
    )
}


@Composable
fun ItemCard(
    itemIndex: Int,
    itemList: List<ItemModel>,
    navController: NavHostController,
    onDelete: (item: ItemModel) -> Unit
) {

    val item = itemList[itemIndex]


    Card(
        Modifier
            .padding(10.dp)
            .clickable {
                onDelete(item)
                //navController.navigate("Detail Screen/${item.id}")
            },
        elevation = CardDefaults.cardElevation(8.dp),
    ) {
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
            Column(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = item.name,
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
                Text(
                    text = item.listId.toString(),
                    modifier = Modifier
                        .padding(start = 16.dp)
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
