package com.example.novci2.model

data class User(var prefix: String = "",
                var firstName: String,
                var middleName: String = "",
                var surname: String,
                var suffix: String = "",
                var balanceCents: Int = 0,
                val ID: Long) {
    val fullName: String
        get() = listOf(prefix, firstName, middleName, surname, suffix).filter { it.isNotBlank() }.joinToString(" ")
    val prefixedSurname: String
        get() = listOf(prefix, surname).filter { it.isNotBlank() }.joinToString(" ")
    val prefixedFirstName: String
        get() = listOf(prefix, firstName).filter { it.isNotBlank() }.joinToString(" ")
}