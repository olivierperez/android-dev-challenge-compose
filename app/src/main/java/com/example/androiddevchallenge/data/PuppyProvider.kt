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
package com.example.androiddevchallenge.data

import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.domain.Puppy

class PuppyProvider {
    fun getAll(): List<Puppy> {
        return listOf(
            Puppy(id = 0, imageRes = R.drawable.puppy_1, name = "Donovan"),
            Puppy(id = 1, imageRes = R.drawable.puppy_2, name = "Olivier"),
            Puppy(id = 2, imageRes = R.drawable.puppy_3, name = "Roxy"),
            Puppy(id = 3, imageRes = R.drawable.puppy_4, name = "Carl"),
            Puppy(id = 4, imageRes = R.drawable.puppy_5, name = "GiftSub"),
            Puppy(id = 5, imageRes = R.drawable.puppy_6, name = "Bot Husky"),
        )
    }
}