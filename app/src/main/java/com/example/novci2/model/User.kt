package com.example.novci2.model

import java.math.BigInteger

data class User(var prefix: String = "",
                var firstName: String,
                var middleName: String = "",
                var surname: String,
                var suffix: String = "",
                var balanceCents: BigInteger = BigInteger.ZERO,
                val ID: Long) {
    val fullName: String
        get() = listOf(prefix, firstName, middleName, surname, suffix).filter { it.isNotBlank() }.joinToString(" ")
    val prefixedSurname: String
        get() = listOf(prefix, surname).filter { it.isNotBlank() }.joinToString(" ")
    val prefixedFirstName: String
        get() = listOf(prefix, firstName).filter { it.isNotBlank() }.joinToString(" ")
}