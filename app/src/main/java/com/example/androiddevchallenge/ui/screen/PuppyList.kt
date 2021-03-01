package com.example.androiddevchallenge.ui.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import androidx.navigation.compose.popUpTo
import com.example.androiddevchallenge.domain.GetPuppies
import com.example.androiddevchallenge.ui.theme.screenPadding
import com.example.androiddevchallenge.ui.toolkit.PuppyCard
import com.example.androiddevchallenge.ui.toolkit.Staggered

@Composable
fun PuppyList(navController: NavController, getPuppies: GetPuppies) {
    Staggered(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(screenPadding),
        columns = 2,
        arrangement = Arrangement.spacedBy(16.dp)
    ) {
        getPuppies().forEach { puppy ->
            PuppyCard(
                onClick = {
                    navController.navigate("puppy_details/${puppy.id}") {
                        popUpTo("puppy_list") {}
                    }
                },
                puppyResource = puppy.imageRes,
                name = puppy.name
            )
        }
    }
}