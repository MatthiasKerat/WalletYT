package com.kapps.wallet.domain

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class CalculateListSumUseCaseTest{

    private val calculateListSumUseCase = CalculateListSumUseCase()

    @Test
    fun testResultWithEmptyListIsNull(){
        val result = calculateListSumUseCase(emptyList())
        assertThat(result).isEqualTo(0f)
    }

    @Test
    fun testResultWithOneListElem(){
        val result = calculateListSumUseCase(listOf(2.3f))
        assertThat(result).isEqualTo(2.3f)
    }

    @Test
    fun testResultWithMultipleListElems(){
        val result = calculateListSumUseCase(listOf(2.3f,3.12f,5f))
        assertThat(result).isEqualTo(10.42f)
    }

    @Test
    fun testResultWithMultipleListElemsWhichResultInANegativeNumber(){
        val result = calculateListSumUseCase(listOf(2.3f,3.12f,-15f))
        assertThat(result).isEqualTo(-9.58f)
    }

}