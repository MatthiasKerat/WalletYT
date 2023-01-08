package com.kapps.wallet.domain

class CalculateListSumUseCase {

    operator fun invoke(list: List<Float>):Float{
        var result = 0f
        for(elem in list){
            result += elem
        }
        return result
    }
}