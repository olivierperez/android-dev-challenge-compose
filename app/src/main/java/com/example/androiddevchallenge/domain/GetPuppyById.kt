package com.example.androiddevchallenge.domain

import com.example.androiddevchallenge.data.PuppyProvider

class GetPuppyById {

    private val provider = PuppyProvider()

    operator fun invoke(id: Int): Puppy {
        return provider.getAll().firstOrNull { it.id == id }
            ?: error("Puppy $id not found!")
    }

}
