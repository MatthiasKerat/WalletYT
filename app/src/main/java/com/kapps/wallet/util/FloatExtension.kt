package com.kapps.wallet.util

import java.text.DecimalFormatSymbols
import java.util.*
import kotlin.math.absoluteValue

fun Float.formatToPrice(locale: Locale, alwaysUseTwoCommaDigits: Boolean = false): String {
    val separator = DecimalFormatSymbols.getInstance(locale).decimalSeparator
    val valueMultipliedWith10Pow2 = (this * 100).toInt()
    val valueBeforeComma = valueMultipliedWith10Pow2 / 100
    val commaValues = valueMultipliedWith10Pow2.absoluteValue % 100
    return if (commaValues != 0 || alwaysUseTwoCommaDigits) {
        val commaValuesString = if (commaValues == 0) {
            "00"
        } else {
            "$commaValues"
        }
        return "$valueBeforeComma$separator$commaValuesString €"
    } else {
        "$valueBeforeComma €"
    }
}