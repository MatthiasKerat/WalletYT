package com.kapps.wallet.domain

import com.google.common.truth.Truth.assertThat
import org.junit.Test


class ParseTransactionValueInputUseCaseTest{
    private val transactionValueInputUseCase = ParseTransactionValueInputUseCase()

    @Test
    fun testZeroWithoutCommaReturnsFalse(){
        val result = transactionValueInputUseCase("0")
        assertThat(result).isFalse()
    }

    @Test
    fun testZeroWithCommaReturnsFalse(){
        val result = transactionValueInputUseCase("0,00")
        assertThat(result).isFalse()
    }

    @Test
    fun testMultipleZeroWithCommaReturnsFalse(){
        val result = transactionValueInputUseCase("00,00")
        assertThat(result).isFalse()
    }

    @Test
    fun testZeroBeforeCommaAndAValueAfterCommaReturnsTrue(){
        val result = transactionValueInputUseCase("0,20")
        assertThat(result).isTrue()
    }

    @Test
    fun testZeroBeforeCommaAndASecondValueAfterCommaReturnsTrue(){
        val result = transactionValueInputUseCase("0,02")
        assertThat(result).isTrue()
    }

    @Test
    fun testNormalSingleValueWithoutCommaReturnsTrue(){
        val result = transactionValueInputUseCase("2")
        assertThat(result).isTrue()
    }

    @Test
    fun testNormalValueWithOneCommaValueAfterReturnsTrue(){
        val result = transactionValueInputUseCase("2,1")
        assertThat(result).isTrue()
    }

    @Test
    fun testNormalValueWithTwoCommaValuesAfterReturnsTrue(){
        val result = transactionValueInputUseCase("2,13")
        assertThat(result).isTrue()
    }

    @Test
    fun testTooLongValueReturnsFalse(){
        val result = transactionValueInputUseCase("2,131")
        assertThat(result).isFalse()
    }

    @Test
    fun testNoValueReturnsFalse(){
        val result = transactionValueInputUseCase("1412a")
        assertThat(result).isFalse()
    }

    @Test
    fun testLeadingZeroValueReturnsTrue(){
        val result = transactionValueInputUseCase("02,21")
        assertThat(result).isTrue()
    }
}