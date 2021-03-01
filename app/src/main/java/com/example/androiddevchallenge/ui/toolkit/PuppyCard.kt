package com.example.androiddevchallenge.ui.toolkit

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R

@Composable
fun PuppyCard(
    @DrawableRes puppyResource: Int,
    name: String,
    backgroundColor: Color = Color.Black,
    contentColor: Color = Color.White,
) {
    Surface(
        color = backgroundColor,
        contentColor = contentColor,
        modifier = Modifier
            .clip(RoundedCornerShape(20.dp))
            .semantics(mergeDescendants = true) {}
    ) {
        Column {
            Image(
                painter = painterResource(puppyResource),
                contentDescription = null,
                contentScale = ContentScale.Crop,
            )
            Text(
                text = name,
                style = MaterialTheme.typography.body1,
                modifier = Modifier.padding(20.dp)
            )
        }
    }
}

@Preview
@Composable
fun PreviewPuppyCard() {
    PuppyCard(
        R.drawable.puppy_1,
        name = "Donovan"
    )
}
