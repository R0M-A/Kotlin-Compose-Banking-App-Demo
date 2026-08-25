package com.example.novci2.util

import java.math.BigInteger

fun String.toCents(): BigInteger {
    return if (isEmpty()) {
        BigInteger.ZERO
    } else {
        toBigDecimal().movePointRight(2).toBigIntegerExact()
    }
}