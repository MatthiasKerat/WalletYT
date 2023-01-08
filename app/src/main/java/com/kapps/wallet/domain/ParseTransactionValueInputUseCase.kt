package com.kapps.wallet.domain

import java.text.DecimalFormatSymbols

class ParseTransactionValueInputUseCase {

    operator fun invoke(value:String):Boolean{
        val decimalPointFormat = DecimalFormatSymbols.getInstance().decimalSeparator

        val regexForNull = "0+$decimalPointFormat?[0]{0,2}"
        if(value.matches(Regex(regexForNull))){
            return false
        }

        val regexGeneral = "[0-9]*$decimalPointFormat?[0-9]{1,2}"
        return value.matches(Regex(regexGeneral))
    }
}