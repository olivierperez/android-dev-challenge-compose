package com.example.androiddevchallenge.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.contentColorFor
import androidx.compose.material.primarySurface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.navigation.NavController
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.domain.GetPuppyById
import com.example.androiddevchallenge.ui.theme.screenPadding
import com.example.androiddevchallenge.ui.toolkit.PuppyCard

@Composable
fun PuppyDetail(navController: NavController, getPuppyById: GetPuppyById, puppyId: Int) {
    val puppy = getPuppyById(puppyId)
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        TopAppBar(
            navigationIcon = {
                IconButton(
                    onClick = {
                              navController.popBackStack()
                    },
                ) {
                    Image(
                        imageVector = ImageVector
                            .vectorResource(R.drawable.ic_arrow_left),
                        contentDescription = null,
                        colorFilter = ColorFilter.tint(contentColorFor(MaterialTheme.colors.primarySurface))
                    )
                }
            },
            title = {
                Text(stringResource(R.string.im_so_cute))
            }
        )
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
}
