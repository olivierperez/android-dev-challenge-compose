package com.example.androiddevchallenge.domain

import com.example.androiddevchallenge.data.PuppyProvider

class GetPuppies {

    private val provider = PuppyProvider()

    operator fun invoke(): List<Puppy> {
        return provider.getAll()
    }

}
