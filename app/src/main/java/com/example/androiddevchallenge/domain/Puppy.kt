package com.example.androiddevchallenge.domain

import androidx.annotation.StringRes

class Puppy(
    val id: Int,
    val name: String,
    @StringRes
    val imageRes: Int
)
