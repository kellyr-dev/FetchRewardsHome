package com.example.fetchrewards.navigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fetchrewards.R

@Composable
fun DetailScreen(id: Int){

    Column (
        modifier = Modifier.fillMaxSize()
            .background(Color.LightGray.copy(.7f)),
        verticalArrangement = Arrangement.Center)

    {
        Image(painterResource(
            R.drawable.logo_item_purple),
            contentDescription = "productImage",
            modifier =Modifier
                .fillMaxWidth()
                .padding(top = 80.dp, start = 40.dp, end = 40.dp)
                .size(200.dp)
                .clip(RoundedCornerShape(12.dp)),
            contentScale = ContentScale.Crop
        )

        Row(
            modifier = Modifier
                .fillMaxHeight()
                .padding(start = 40.dp, top = 8.dp, end = 40.dp)
        ){
            Text(
                text ="name",
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

            Text(
                text ="id",
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