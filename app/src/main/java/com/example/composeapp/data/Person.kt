package com.example.composeapp.data

import androidx.compose.runtime.saveable.listSaver

data class Person(val name: String, val age: Int)

val PersonSaver = listSaver<Person, Any>(
    save = { listOf(it.name, it.age) },
    restore = { Person(it[0] as String, it[1] as Int) }
)


