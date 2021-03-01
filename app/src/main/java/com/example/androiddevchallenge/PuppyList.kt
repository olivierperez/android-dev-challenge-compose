package com.example.androiddevchallenge

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.androiddevchallenge.ui.toolkit.PuppyCard
import com.example.androiddevchallenge.ui.toolkit.Staggered

@Composable
fun PuppyList(navController: NavHostController) {
    Staggered(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        columns = 2,
        arrangement = Arrangement.spacedBy(16.dp)
    ) {
        PuppyCard(puppyResource = R.drawable.puppy_1, name = "Donovan")
        PuppyCard(puppyResource = R.drawable.puppy_2, name = "Olivier")
        PuppyCard(puppyResource = R.drawable.puppy_3, name = "Roxy")
        PuppyCard(puppyResource = R.drawable.puppy_4, name = "Carl")
        PuppyCard(puppyResource = R.drawable.puppy_5, name = "GiftSub")
        PuppyCard(puppyResource = R.drawable.puppy_6, name = "Bot Husky")
    }
}