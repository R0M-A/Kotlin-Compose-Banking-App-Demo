package com.example.novci2.util

import java.math.BigInteger
import kotlin.text.toBigDecimal

fun String.toCents(): BigInteger {
    return if (isEmpty()) {
        BigInteger.ZERO
    } else {
        toBigDecimal().movePointRight(2).toBigIntegerExact()
    }
}

//TODO: look at android.icu.util.Currency
//TODO: Localizaiton
fun BigInteger.toMoneyString(currency: String = "€"): String {
    val amount = toBigDecimal().movePointLeft(2)
    return "%,.2f %s".format(amount, currency)
}