/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import androidx.navigation.compose.popUpTo
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.domain.GetPuppies
import com.example.androiddevchallenge.ui.theme.screenPadding
import com.example.androiddevchallenge.ui.toolkit.PuppyCard
import com.example.androiddevchallenge.ui.toolkit.Staggered

@Composable
fun PuppyList(navController: NavController, getPuppies: GetPuppies) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier.padding(screenPadding),
            text = stringResource(R.string.adopt_one_of_them),
            style = MaterialTheme.typography.h1,
            textAlign = TextAlign.Center
        )
        Staggered(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    top = 0.dp,
                    end = screenPadding,
                    bottom = screenPadding,
                    start = screenPadding
                ),
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
}
