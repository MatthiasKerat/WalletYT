package com.kapps.wallet.util

import com.google.common.truth.Truth.assertThat
import org.junit.Test
import java.util.*

class FloatExtensionKtTest {

    @Test
    fun testFloatToGermanFormatWithoutCommaValue() {
        val number = 10f
        val result = number.formatToPrice(Locale.GERMAN)
        assertThat(result).isEqualTo("10 €")
    }

    @Test
    fun testFloatToUSFormatWithoutCommaValue() {
        val number = 10f
        val result = number.formatToPrice(Locale.US)
        assertThat(result).isEqualTo("10 €")
    }

    @Test
    fun testFloatToGermanFormatWithOneCommaValue() {
        val number = 10.5f
        val result = number.formatToPrice(Locale.GERMAN)
        assertThat(result).isEqualTo("10,50 €")
    }

    @Test
    fun testFloatToUSFormatWithOneCommaValue() {
        val number = 10.5f
        val result = number.formatToPrice(Locale.US)
        assertThat(result).isEqualTo("10.50 €")
    }

    @Test
    fun testFloatFormatWithTwoCommaValues() {
        val number = 11.51f
        val result = number.formatToPrice(Locale.GERMAN)
        assertThat(result).isEqualTo("11,51 €")
    }

    @Test
    fun testFloatIsZeroFormatToSingleZero() {
        val number = 0f
        val result = number.formatToPrice(Locale.US)
        assertThat(result).isEqualTo("0 €")
    }

    @Test
    fun testFloatIsZeroWithTwoCommaValuesIfThereIsNoCommaValueButItsForced() {
        val number = 0f
        val result = number.formatToPrice(Locale.US, alwaysUseTwoCommaDigits = true)
        assertThat(result).isEqualTo("0.00 €")
    }

    @Test
    fun testNegativeFloatWithCommaValueIsFormattedCorrectly() {
        val number = -1.20f
        val result = number.formatToPrice(Locale.US)
        assertThat(result).isEqualTo("-1.20 €")
    }

    @Test
    fun testNegativeFloatWithoutCommaValueIsFormattedCorrectly() {
        val number = -5f
        val result = number.formatToPrice(Locale.US)
        assertThat(result).isEqualTo("-5 €")
    }

    @Test
    fun testNegativeFloatWithoutCommaValueAndForcedToTwoCommasIsFormattedCorrectly() {
        val number = -5f
        val result = number.formatToPrice(Locale.US, alwaysUseTwoCommaDigits = true)
        assertThat(result).isEqualTo("-5.00 €")
    }
    
}