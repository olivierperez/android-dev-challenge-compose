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
package com.example.androiddevchallenge.ui.toolkit

import androidx.annotation.IntRange
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.dp

@Composable
fun Staggered(
    modifier: Modifier,
    @IntRange(from = 1) columns: Int,
    arrangement: Arrangement.HorizontalOrVertical,
    content: @Composable () -> Unit
) {
    Layout(
        modifier = modifier,
        content = content
    ) { measurables, constraints ->
        val spacing = arrangement.spacing.roundToPx()
        val columnHeights = IntArray(columns)
        val columnWidth = (constraints.maxWidth - spacing * (columns - 1)) / columns

        val childConstraint = Constraints(
            minWidth = columnWidth,
            maxWidth = columnWidth,
            minHeight = 0,
            maxHeight = constraints.maxHeight
        )

        val placeables = measurables.map { measurable ->
            measurable.measure(childConstraint)
        }.map { placeable ->
            val min = columnHeights.minOrNull()!!
            val shorterColumn = columnHeights.indexOf(min)
            columnHeights[shorterColumn] += placeable.height + spacing

            Pair(placeable, shorterColumn)
        }

        val highestColumn = (columnHeights.maxOrNull() ?: 0) - spacing
        layout(
            constraints.maxWidth,
            highestColumn.coerceAtLeast(constraints.minHeight)
        ) {
            val columnCurrentHeights = IntArray(columns)

            placeables.forEach { (placeable, column) ->
                val top = columnCurrentHeights[column]
                val left = (columnWidth + spacing) * column
                placeable.place(left, top)

                columnCurrentHeights[column] += placeable.height + spacing
            }
        }
    }
}

@Preview(widthDp = 200, heightDp = 200)
@Composable
fun StaggeredPreviewPuppy() {
    Staggered(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        columns = 2,
        arrangement = Arrangement.spacedBy(16.dp)
    ) {
        PreviewPuppyCard()
        PreviewPuppyCard()
        PreviewPuppyCard()
    }
}

@Preview(widthDp = 200, heightDp = 200)
@Composable
fun StaggeredPreviewThreeColumns() {
    Staggered(
        modifier = Modifier
            .fillMaxSize()
            .padding(4.dp)
            .verticalScroll(rememberScrollState()),
        columns = 3,
        arrangement = Arrangement.spacedBy(4.dp)
    ) {
        Text("Olivier")
        Text("Donovan\nsur\n4\nlignes")
        Text("Roxana est partie")
        Text("mais c'était cool de la voir")
    }
}
