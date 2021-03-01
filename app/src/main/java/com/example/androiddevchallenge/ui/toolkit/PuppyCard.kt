package com.example.androiddevchallenge.ui.toolkit

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R

@Composable
fun PuppyCard(
    modifier: Modifier = Modifier,
    @DrawableRes puppyResource: Int,
    name: String,
    backgroundColor: Color = MaterialTheme.colors.primary,
    contentColor: Color = contentColorFor(backgroundColor),
    onClick: (() -> Unit)? = null,
) {
    Card(
        modifier = modifier
            .semantics(mergeDescendants = true) {},
        backgroundColor = backgroundColor,
        contentColor = contentColor,
        shape = RoundedCornerShape(20.dp),
        elevation = 4.dp
    ) {
        Column(
            modifier = Modifier
                .clickable(enabled = onClick != null, onClick = onClick ?: {})
        ) {
            Image(
                painter = painterResource(puppyResource),
                contentDescription = null,
                contentScale = ContentScale.Crop,
            )
            Text(
                modifier = Modifier.padding(20.dp),
                text = name,
                style = MaterialTheme.typography.body1
            )
        }
    }
}

@Preview
@Composable
fun PreviewPuppyCard() {
    PuppyCard(
        name = "Donovan",
        puppyResource = R.drawable.puppy_1
    )
}
