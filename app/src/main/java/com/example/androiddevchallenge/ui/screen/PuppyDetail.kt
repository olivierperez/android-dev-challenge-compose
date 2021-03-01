package com.example.androiddevchallenge.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.androiddevchallenge.domain.GetPuppyById
import com.example.androiddevchallenge.ui.theme.screenPadding
import com.example.androiddevchallenge.ui.toolkit.PuppyCard

@Composable
fun PuppyDetail(navController: NavController, getPuppyById: GetPuppyById, puppyId: Int) {
    val puppy = getPuppyById(puppyId)
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
            .padding(screenPadding),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        PuppyCard(
            puppyResource = puppy.imageRes,
            name = puppy.name
        )
    }
}
