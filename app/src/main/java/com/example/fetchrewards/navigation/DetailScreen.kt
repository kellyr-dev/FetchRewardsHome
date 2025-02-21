package com.example.fetchrewards.navigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
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
import com.example.fetchrewards.R
import com.example.fetchrewards.viewModel.FetchViewModel

@Composable
fun DetailScreen(id: Int){

    val viewModel : FetchViewModel = hiltViewModel()
    val model = viewModel.state.detailData.get(id)

    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray.copy(.7f)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    )

    {
        Image(painterResource(
            R.drawable.logo_item_purple),
            contentDescription = "productImage",
            modifier =Modifier
                .fillMaxWidth()
                .padding(top = 80.dp, start = 40.dp, end = 40.dp)
                .size(200.dp)
                .clip(RoundedCornerShape(12.dp)),
            contentScale = ContentScale.Fit
        )

        Column (
            verticalArrangement = Arrangement.Top,
            modifier = Modifier
                .fillMaxHeight()
                .padding(start = 40.dp, top = 4.dp, end = 40.dp)
        ){
            Text(
                text = model?.name.toString(),
                modifier = Modifier
                    .padding(4.dp)
                    .basicMarquee(),
                textAlign = TextAlign.Center,
                color = Color.Black,
                fontWeight = FontWeight.SemiBold,
                fontFamily = FontFamily(Font(R.font.alexandria_medium)),
                fontSize = 18.sp,
                maxLines = 1,
            )

            Text(
                text = "Category "+model?.listId.toString(),
                modifier = Modifier
                    .padding(4.dp)
                    .basicMarquee(),
                textAlign = TextAlign.Start,
                color = Color.Black,
                fontWeight = FontWeight.SemiBold,
                fontFamily = FontFamily(Font(R.font.alexandria_medium)),
                fontSize = 18.sp,
                maxLines = 1,
            )
        }
    }

}