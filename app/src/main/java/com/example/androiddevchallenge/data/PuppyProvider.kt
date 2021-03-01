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